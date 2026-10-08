package com.guoche.teyvatdelight.registry;

import com.guoche.teyvatdelight.EmptyFeatherMothEntity;
import com.guoche.teyvatdelight.KatheryneEntity;
import com.guoche.teyvatdelight.StarconchEntity;
import com.guoche.teyvatdelight.TeyvatDelight;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Owns entity type registrations; holders are resolved by deferred suppliers. */
public final class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TeyvatDelight.MODID);

    public static final RegistryObject<EntityType<StarconchEntity>> STARCONCH = ENTITIES.register(
            "starconch",
            () -> EntityType.Builder.of(StarconchEntity::new, MobCategory.CREATURE)
                    .sized(0.5F, 0.3F)
                    .clientTrackingRange(8)
                    .build("starconch")
    );

    public static final RegistryObject<EntityType<EmptyFeatherMothEntity>> EMPTY_FEATHER_MOTH = ENTITIES.register(
            "empty_feather_moth",
            () -> EntityType.Builder.of(EmptyFeatherMothEntity::new, MobCategory.CREATURE)
                    .sized(0.65F, 0.5F)
                    .clientTrackingRange(8)
                    .build("empty_feather_moth")
    );

    public static final RegistryObject<EntityType<KatheryneEntity>> KATHERYNE = ENTITIES.register(
            "katheryne",
            () -> EntityType.Builder.of(KatheryneEntity::new, MobCategory.MISC)
                    .sized(0.65F, 1.9F)
                    .clientTrackingRange(8)
                    .build("katheryne")
    );

    private ModEntityTypes() {
    }

    public static void register(IEventBus modEventBus) {
        ENTITIES.register(modEventBus);
    }
}
