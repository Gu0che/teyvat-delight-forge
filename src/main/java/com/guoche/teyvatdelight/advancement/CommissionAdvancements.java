package com.guoche.teyvatdelight.advancement;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

/** Commission stories award criteria independently; earning one never grants the whole challenge. */
public final class CommissionAdvancements {
  private CommissionAdvancements() {}

  private static final java.util.Set<ServerPlayer> pendingVisibility = new java.util.HashSet<>();

  public static void scheduleVisibility(ServerPlayer player) {
    pendingVisibility.add(player);
  }

  public static void scheduleVisibility(ServerPlayer player, ResourceLocation earned) {
    var challenge = player.server.getAdvancements().getAdvancement(ResourceLocation.tryParse("teyvatdelight:main/all_commission_stories"));
    if (challenge != null && (earned.toString().equals("teyvatdelight:main/all_commission_stories")
        || earned.toString().equals("teyvatdelight:main/welcome_adventurers_guild")
        || challenge.getCriteria().containsKey(earned.toString())))
      scheduleVisibility(player);
  }

  public static void forget(ServerPlayer player) {
    pendingVisibility.remove(player);
  }

  public static void clearVisibility() {
    pendingVisibility.clear();
  }

  public static void flushVisibility() {
    var queued = java.util.List.copyOf(pendingVisibility);
    pendingVisibility.clear();
    for (var player : queued) {
      var packet = visibilityPacket(player);
      if (packet == null || player.connection == null) continue;
      // Send after vanilla visibility changes, without mutating shared advancement definitions.
      player.getAdvancements().flushDirty(player);
      player.connection.send(packet);
    }
  }

  public static net.minecraft.network.protocol.game.ClientboundUpdateAdvancementsPacket visibilityPacket(
      ServerPlayer player) {
    var manager = player.server.getAdvancements();
    var challenge = manager.getAdvancement(ResourceLocation.tryParse("teyvatdelight:main/all_commission_stories"));
    if (challenge == null) return null;
    java.util.List<net.minecraft.advancements.Advancement> originals = new java.util.ArrayList<>();
    originals.add(challenge);
    var welcome = manager.getAdvancement(ResourceLocation.tryParse("teyvatdelight:main/welcome_adventurers_guild"));
    if (welcome != null) originals.add(welcome);
    for (var criterion : challenge.getCriteria().keySet()) {
      var id = ResourceLocation.tryParse(criterion);
      var story = id == null ? null : manager.getAdvancement(id);
      if (story != null) originals.add(story);
    }
    if (originals.stream().noneMatch(a -> player.getAdvancements().getOrStartProgress(a).isDone()))
      return null;
    var progress = new java.util.LinkedHashMap<ResourceLocation, net.minecraft.advancements.AdvancementProgress>();
    var added = new java.util.ArrayList<net.minecraft.advancements.Advancement>();
    var copies = new java.util.HashMap<ResourceLocation, net.minecraft.advancements.Advancement>();
    for (var original : originals) {
      progress.put(original.getId(), player.getAdvancements().getOrStartProgress(original));
      added.add(copyForDisplay(player, original, copies));
    }
    return new net.minecraft.network.protocol.game.ClientboundUpdateAdvancementsPacket(
        false, added, progress.keySet(), progress);
  }

  private static net.minecraft.advancements.Advancement copyForDisplay(ServerPlayer player,
      net.minecraft.advancements.Advancement source,
      java.util.Map<ResourceLocation, net.minecraft.advancements.Advancement> copies) {
    if (copies.containsKey(source.getId())) return copies.get(source.getId());
    // Forge constructors register children; clone parents too so the server tree stays untouched.
    var parent = source.getParent() == null ? null : copyForDisplay(player, source.getParent(), copies);
    var original = source.getDisplay();
    net.minecraft.advancements.DisplayInfo display = null;
    if (original != null) {
      display = new net.minecraft.advancements.DisplayInfo(original.getIcon().copy(),
          original.getTitle(), original.getDescription(), original.getBackground(), original.getFrame(),
          original.shouldShowToast() && !player.getAdvancements().getOrStartProgress(source).isDone(),
          original.shouldAnnounceChat(), false);
      display.setLocation(original.getX(), original.getY());
    }
    var copy = new net.minecraft.advancements.Advancement(source.getId(), parent, display,
        source.getRewards(), source.getCriteria(), source.getRequirements(), source.sendsTelemetryEvent());
    copies.put(source.getId(), copy);
    return copy;
  }

  public static void update(ServerPlayer player) {
    var challenge = player.server.getAdvancements().getAdvancement(ResourceLocation.tryParse("teyvatdelight:main/all_commission_stories"));
    if (challenge == null || player.getAdvancements().getOrStartProgress(challenge).isDone()) return;
    for (String criterion : java.util.stream.StreamSupport.stream(
        player.getAdvancements().getOrStartProgress(challenge).getRemainingCriteria().spliterator(), false).toList()) {
      var id = ResourceLocation.tryParse(criterion);
      var story = id == null ? null : player.server.getAdvancements().getAdvancement(id);
      if (story != null && player.getAdvancements().getOrStartProgress(story).isDone())
        player.getAdvancements().award(challenge, criterion);
    }
  }
}
