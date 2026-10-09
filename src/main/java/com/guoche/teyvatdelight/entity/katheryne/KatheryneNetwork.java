package com.guoche.teyvatdelight.entity.katheryne;

import com.guoche.teyvatdelight.KatheryneNetwork.Action;
import com.guoche.teyvatdelight.KatheryneNetwork.Sync;
import com.guoche.teyvatdelight.KatheryneSnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public final class KatheryneNetwork {
  private static final SimpleChannel CHANNEL =
      NetworkRegistry.newSimpleChannel(
          new ResourceLocation("teyvatdelight", "katheryne"), () -> "16", "16"::equals, "16"::equals);

  private KatheryneNetwork() {}

  public static void register() {
    CHANNEL.registerMessage(
        0,
        Sync.class,
        Sync::encode,
        Sync::decode,
        Sync::handle,
        Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    CHANNEL.registerMessage(
        1,
        Action.class,
        Action::encode,
        Action::decode,
        Action::handle,
        Optional.of(NetworkDirection.PLAY_TO_SERVER));
  }

  public static void sendSnapshot(ServerPlayer player, KatheryneSnapshot snapshot) {
    snapshot = boundedSnapshot(player, snapshot);
    CHANNEL.sendTo(
        new Sync(snapshot), player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
  }

  /** Preflight actual encoded stacks, including NBT supplied by other mods. */
  private static KatheryneSnapshot boundedSnapshot(ServerPlayer player, KatheryneSnapshot value) {
    var buffer = new net.minecraft.network.FriendlyByteBuf(io.netty.buffer.Unpooled.buffer());
    try {
      writeSnapshot(buffer, value);
      if (buffer.writerIndex() <= 1000000) return value;
      com.guoche.teyvatdelight.TeyvatDelight.LOGGER.warn(
          "Katheryne snapshot exceeds safe packet budget: {} bytes", buffer.writerIndex());
    } catch (RuntimeException exception) {
      com.guoche.teyvatdelight.TeyvatDelight.LOGGER.warn("Invalid Katheryne snapshot", exception);
    } finally {
      buffer.release();
    }
    return new KatheryneSnapshot(
        value.menuId(),
        ItemStack.EMPTY,
        false,
        value.secondsUntilRefresh(),
        value.immediateRefresh(),
        List.of(),
        List.of(),
        List.of(),
        "",
        "gui.teyvatdelight.katheryne.invalid_rules",
        value.revision(),
        false,
        0,
        -1);
  }

  public static void sendAction(int menuId, int kind, int index) {
    com.guoche.teyvatdelight.client.katheryne.KatheryneClientNetwork.sendAction(
        menuId, kind, index);
  }

  public static void sendAction(int menuId, int kind, int index, long revision, String key) {
    CHANNEL.sendToServer(new Action(menuId, kind, index, revision, key));
  }

  public static void writeSnapshot(FriendlyByteBuf buf, KatheryneSnapshot value) {
    buf.writeVarInt(value.menuId());
    buf.writeUtf(value.commissions(), 262144);
    buf.writeUtf(value.feedback(), 1024);
    buf.writeLong(value.revision());
    buf.writeBoolean(value.partial());
    buf.writeVarInt(value.patchKind());
    buf.writeVarInt(value.patchIndex());
    buf.writeItem(value.target());
    buf.writeBoolean(value.completed());
    buf.writeVarInt(value.secondsUntilRefresh());
    buf.writeBoolean(value.immediateRefresh());
    buf.writeVarInt(value.rewards().size());
    for (KatheryneSnapshot.StackAmount reward : value.rewards()) {
      buf.writeItem(reward.icon());
      buf.writeVarInt(reward.count());
    }
    buf.writeVarInt(value.shop().size());
    for (KatheryneSnapshot.Sale sale : value.shop()) {
      buf.writeUtf(sale.key(), 128);
      buf.writeVarInt(sale.outputs().size());
      for (KatheryneSnapshot.StackAmount output : sale.outputs()) {
        buf.writeItem(output.icon());
        buf.writeVarInt(output.count());
      }
      buf.writeVarInt(sale.prices().size());
      for (KatheryneSnapshot.StackAmount price : sale.prices()) {
        buf.writeItem(price.icon());
        buf.writeVarInt(price.count());
      }
      buf.writeVarInt(sale.remaining());
    }
    buf.writeVarInt(value.daily().size());
    for (KatheryneSnapshot.DailySale sale : value.daily()) {
      buf.writeUtf(sale.key(), 128);
      buf.writeUtf(sale.name(), 256);
      buf.writeVarInt(sale.outputs().size());
      for (ItemStack output : sale.outputs()) buf.writeItem(output);
      buf.writeVarInt(sale.prices().size());
      for (KatheryneSnapshot.StackAmount price : sale.prices()) {
        buf.writeItem(price.icon());
        buf.writeVarInt(price.count());
      }
      buf.writeBoolean(sale.purchased());
    }
    writeStores(buf, value.stores());
  }

  public static KatheryneSnapshot readSnapshot(FriendlyByteBuf buf) {
    int menuId = buf.readVarInt();
    String commissions = buf.readUtf(262144), feedback = buf.readUtf(1024);
    long revision = buf.readLong();
    boolean partial = buf.readBoolean();
    int patchKind = buf.readVarInt(), patchIndex = buf.readVarInt();
    ItemStack target = buf.readItem();
    boolean completed = buf.readBoolean();
    int seconds = buf.readVarInt();
    boolean immediate = buf.readBoolean();
    List<KatheryneSnapshot.StackAmount> rewards = new ArrayList<>();
    for (int i = boundedSize(buf); i > 0; i--) {
      rewards.add(new KatheryneSnapshot.StackAmount(buf.readItem(), buf.readVarInt()));
    }
    List<KatheryneSnapshot.Sale> shop = new ArrayList<>();
    for (int i = boundedSize(buf); i > 0; i--) {
      String saleKey = buf.readUtf(128);
      int outputCount = boundedSize(buf);
      if (outputCount == 0 || outputCount > 128)
        throw new IllegalArgumentException("Invalid Katheryne output count");
      List<KatheryneSnapshot.StackAmount> outputs = new ArrayList<>();
      for (int j = 0; j < outputCount; j++) {
        outputs.add(new KatheryneSnapshot.StackAmount(buf.readItem(), buf.readVarInt()));
      }
      int priceCount = boundedSize(buf);
      if (priceCount == 0 || priceCount > 128)
        throw new IllegalArgumentException("Invalid Katheryne price count");
      List<KatheryneSnapshot.StackAmount> prices = new ArrayList<>();
      for (int j = 0; j < priceCount; j++) {
        prices.add(new KatheryneSnapshot.StackAmount(buf.readItem(), buf.readVarInt()));
      }
      shop.add(new KatheryneSnapshot.Sale(outputs, prices, buf.readVarInt(), saleKey));
    }
    List<KatheryneSnapshot.DailySale> daily = new ArrayList<>();
    for (int i = boundedSize(buf); i > 0; i--) {
      String key = buf.readUtf(128);
      String name = buf.readUtf(256);
      int count = boundedSize(buf);
      if (count == 0 || count > 128)
        throw new IllegalArgumentException("Invalid Katheryne daily output count");
      List<ItemStack> outputs = new ArrayList<>();
      for (int j = 0; j < count; j++) outputs.add(buf.readItem());
      int priceCount = boundedSize(buf);
      if (priceCount == 0 || priceCount > 128)
        throw new IllegalArgumentException("Invalid Katheryne daily price count");
      List<KatheryneSnapshot.StackAmount> prices = new ArrayList<>();
      for (int j = 0; j < priceCount; j++) {
        prices.add(new KatheryneSnapshot.StackAmount(buf.readItem(), buf.readVarInt()));
      }
      daily.add(new KatheryneSnapshot.DailySale(key, outputs, prices, buf.readBoolean(), name));
    }
    return new KatheryneSnapshot(
        menuId,
        target,
        completed,
        seconds,
        immediate,
        rewards,
        shop,
        daily,
        commissions,
        feedback,
        revision,
        partial,
        patchKind,
        patchIndex,
        readStores(buf));
  }

  private static void writeStores(FriendlyByteBuf buf, KatheryneSnapshot.StoreView view) {
    buf.writeVarInt(view.headers().size());
    for (var header : view.headers()) {
      buf.writeUtf(header.id(), 128);
      buf.writeUtf(header.title(), 256);
      buf.writeBoolean(header.locked());
      buf.writeComponent(header.lockReason());
    }
    buf.writeUtf(view.active(), 128);
    buf.writeVarInt(view.seconds());
    buf.writeBoolean(view.replaceRows());
    buf.writeVarInt(view.rows().size());
    for (var row : view.rows()) {
      buf.writeUtf(row.id(), 128);
      buf.writeUtf(row.name(), 256);
      buf.writeVarInt(row.remaining());
      buf.writeBoolean(row.locked());
      buf.writeComponent(row.lockReason());
      writeAmounts(buf, row.outputs());
      writeAmounts(buf, row.prices());
    }
  }

  private static void writeAmounts(
      FriendlyByteBuf buf, List<KatheryneSnapshot.StackAmount> stacks) {
    if (stacks.isEmpty() || stacks.size() > 128)
      throw new IllegalArgumentException("Invalid store stack count");
    buf.writeVarInt(stacks.size());
    for (var stack : stacks) {
      if (stack.icon().isEmpty() || stack.count() < 1 || stack.count() > 1000000)
        throw new IllegalArgumentException("Invalid store product/payment");
      buf.writeItem(stack.icon());
      buf.writeVarInt(stack.count());
    }
  }

  private static List<KatheryneSnapshot.StackAmount> readAmounts(FriendlyByteBuf buf) {
    int count = boundedSize(buf);
    if (count < 1 || count > 128) throw new IllegalArgumentException("Invalid store stack count");
    List<KatheryneSnapshot.StackAmount> result = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      ItemStack icon = buf.readItem();
      int amount = buf.readVarInt();
      if (icon.isEmpty() || amount < 1 || amount > 1000000)
        throw new IllegalArgumentException("Invalid store product/payment");
      result.add(new KatheryneSnapshot.StackAmount(icon, amount));
    }
    return List.copyOf(result);
  }

  private static KatheryneSnapshot.StoreView readStores(FriendlyByteBuf buf) {
    int count = boundedSize(buf);
    if (count > 64) throw new IllegalArgumentException("Too many shop tabs");
    List<KatheryneSnapshot.StoreHeader> headers = new ArrayList<>();
    java.util.Set<String> ids = new java.util.HashSet<>();
    for (int i = 0; i < count; i++) {
      String id = buf.readUtf(128), title = buf.readUtf(256);
      if (id.isEmpty() || !ids.add(id)) throw new IllegalArgumentException("Invalid shop ID");
      headers.add(new KatheryneSnapshot.StoreHeader(id, title, buf.readBoolean(), buf.readComponent()));
    }
    String active = buf.readUtf(128);
    int seconds = buf.readVarInt();
    boolean replace = buf.readBoolean();
    List<KatheryneSnapshot.StoreRow> rows = new ArrayList<>();
    ids.clear();
    for (int i = boundedSize(buf); i > 0; i--) {
      String id = buf.readUtf(128), name = buf.readUtf(256);
      int remaining = buf.readVarInt();
      if (id.isEmpty() || !ids.add(id) || remaining < -1 || remaining > 1000000)
        throw new IllegalArgumentException("Invalid store row");
      rows.add(
          readStoreRow(buf, id, name, remaining));
    }
    return new KatheryneSnapshot.StoreView(
        List.copyOf(headers), active, List.copyOf(rows), seconds, replace);
  }

  private static KatheryneSnapshot.StoreRow readStoreRow(FriendlyByteBuf buf, String id, String name, int remaining) {
    boolean locked = buf.readBoolean();
    var reason = buf.readComponent();
    return new KatheryneSnapshot.StoreRow(id, name, readAmounts(buf), readAmounts(buf), remaining, locked, reason);
  }

  private static int boundedSize(FriendlyByteBuf buf) {
    int size = buf.readVarInt();
    if (size < 0 || size > 1024)
      throw new IllegalArgumentException("Katheryne list exceeds 1024 entries");
    return size;
  }
}
