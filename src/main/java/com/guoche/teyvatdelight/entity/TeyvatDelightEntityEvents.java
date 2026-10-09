package com.guoche.teyvatdelight.entity;

import com.guoche.teyvatdelight.EmptyFeatherMothEntity;
import com.guoche.teyvatdelight.KatheryneEntity;
import com.guoche.teyvatdelight.StarconchEntity;
import com.guoche.teyvatdelight.TeyvatDelight;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = TeyvatDelight.MODID, bus = EventBusSubscriber.Bus.MOD)
public class TeyvatDelightEntityEvents {
    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(TeyvatDelight.STARCONCH.get(), StarconchEntity.createAttributes().build());
        event.put(TeyvatDelight.EMPTY_FEATHER_MOTH.get(), EmptyFeatherMothEntity.createAttributes().build());
        event.put(TeyvatDelight.KATHERYNE.get(), KatheryneEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void onRegisterSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(
                TeyvatDelight.STARCONCH.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                StarconchEntity::checkStarconchSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND
        );
        event.register(
                TeyvatDelight.EMPTY_FEATHER_MOTH.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                EmptyFeatherMothEntity::checkSpawnRules,
                SpawnPlacementRegisterEvent.Operation.AND
        );
    }
}




