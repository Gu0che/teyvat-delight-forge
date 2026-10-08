package com.guoche.teyvatdelight.registry;

import com.guoche.teyvatdelight.advancement.AdvancementEvents;
import com.guoche.teyvatdelight.advancement.CountryChallengeRewards;
import com.guoche.teyvatdelight.crop.CropEvents;
import com.guoche.teyvatdelight.entity.katheryne.KatheryneVillageSpawner;
import com.guoche.teyvatdelight.entity.katheryne.MerchantEvents;
import com.guoche.teyvatdelight.item.WindWingsFlight;
import com.guoche.teyvatdelight.loot.LootEvents;
import com.guoche.teyvatdelight.worldgen.MufengVillageGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;

public final class ModEvents {
    private ModEvents() {
    }

    public static void register() {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGHEST, CropEvents::harvestTeyvatCropBeforeOtherRightClickHandlers);
        MinecraftForge.EVENT_BUS.addListener(CropEvents::syncGlazeLilies);
        MinecraftForge.EVENT_BUS.addListener(MerchantEvents::registerTeyvatMerchantTrades);
        MinecraftForge.EVENT_BUS.addListener(LootEvents::configurePrimogemChestLoot);
        MinecraftForge.EVENT_BUS.addListener(AdvancementEvents::arrangeAdvancementDisplay);
        MinecraftForge.EVENT_BUS.addListener(CountryChallengeRewards::onAdvancementEarned);
        MinecraftForge.EVENT_BUS.addListener(WindWingsFlight::onPlayerTick);
        KatheryneVillageSpawner.register();
        MufengVillageGeneration.register();
    }
}
