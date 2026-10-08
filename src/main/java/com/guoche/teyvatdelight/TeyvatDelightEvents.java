package com.guoche.teyvatdelight;

import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;

/** @deprecated Event implementations are grouped by responsibility. */
@Deprecated
public final class TeyvatDelightEvents {
    private TeyvatDelightEvents() {
    }

    public static void harvestTeyvatCropBeforeOtherRightClickHandlers(PlayerInteractEvent.RightClickBlock event) {
        com.guoche.teyvatdelight.crop.CropEvents.harvestTeyvatCropBeforeOtherRightClickHandlers(event);
    }

    public static void syncGlazeLilies(TickEvent.LevelTickEvent event) {
        com.guoche.teyvatdelight.crop.CropEvents.syncGlazeLilies(event);
    }

    public static void registerTeyvatMerchantTrades(VillagerTradesEvent event) {
        com.guoche.teyvatdelight.entity.katheryne.MerchantEvents.registerTeyvatMerchantTrades(event);
    }

    public static void arrangeAdvancementDisplay(AddReloadListenerEvent event) {
        com.guoche.teyvatdelight.advancement.AdvancementEvents.arrangeAdvancementDisplay(event);
    }

    public static void configurePrimogemChestLoot(LootTableLoadEvent event) {
        com.guoche.teyvatdelight.loot.LootEvents.configurePrimogemChestLoot(event);
    }

    public static void addItemDescription(ItemTooltipEvent event) {
        com.guoche.teyvatdelight.client.ItemDescriptionTooltips.addItemDescription(event);
    }
}
