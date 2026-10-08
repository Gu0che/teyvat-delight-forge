package com.guoche.teyvatdelight;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

/**
 * @deprecated Use {@link com.guoche.teyvatdelight.entity.katheryne.KatheryneNetwork} for new
 *     integrations.
 */
@Deprecated
public final class KatheryneNetwork {
  private KatheryneNetwork() {}

  public static void register() {
    com.guoche.teyvatdelight.entity.katheryne.KatheryneNetwork.register();
  }

  public static void sendSnapshot(ServerPlayer player, KatheryneSnapshot snapshot) {
    com.guoche.teyvatdelight.entity.katheryne.KatheryneNetwork.sendSnapshot(player, snapshot);
  }

  public static void sendAction(int menuId, int kind, int index) {
    com.guoche.teyvatdelight.entity.katheryne.KatheryneNetwork.sendAction(menuId, kind, index);
  }

  public record Sync(KatheryneSnapshot snapshot) {
    public static void encode(Sync message, FriendlyByteBuf buf) {
      com.guoche.teyvatdelight.entity.katheryne.KatheryneNetwork.writeSnapshot(
          buf, message.snapshot());
    }

    public static Sync decode(FriendlyByteBuf buf) {
      return new Sync(com.guoche.teyvatdelight.entity.katheryne.KatheryneNetwork.readSnapshot(buf));
    }

    public static void handle(Sync message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = contextSupplier.get();
      context.enqueueWork(() -> KatheryneClientNetwork.receive(message.snapshot()));
      context.setPacketHandled(true);
    }
  }

  public record Action(int menuId, int kind, int index, long revision, String key) {
    public Action(int menuId, int kind, int index) {
      this(menuId, kind, index, -1, "");
    }

    public static void encode(Action message, FriendlyByteBuf buf) {
      buf.writeVarInt(message.menuId());
      buf.writeVarInt(message.kind());
      buf.writeVarInt(message.index());
      buf.writeLong(message.revision());
      buf.writeUtf(message.key(), 128);
    }

    public static Action decode(FriendlyByteBuf buf) {
      return new Action(
          buf.readVarInt(), buf.readVarInt(), buf.readVarInt(), buf.readLong(), buf.readUtf(128));
    }

    public static void handle(Action message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = contextSupplier.get();
      context.enqueueWork(
          () -> {
            ServerPlayer player = context.getSender();
            if (player != null
                && player.containerMenu instanceof KatheryneMenu menu
                && menu.containerId == message.menuId())
              menu.handleAction(
                  player, message.kind(), message.index(), message.revision(), message.key());
          });
      context.setPacketHandled(true);
    }
  }
}
