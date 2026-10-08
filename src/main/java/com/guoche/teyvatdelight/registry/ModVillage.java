package com.guoche.teyvatdelight.registry;

import com.google.common.collect.ImmutableSet;
import com.guoche.teyvatdelight.TeyvatDelight;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Owns villager and POI registrations; holders are resolved by deferred suppliers. */
public final class ModVillage {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, TeyvatDelight.MODID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TeyvatDelight.MODID);

    public static final RegistryObject<PoiType> TEYVAT_MERCHANT_POI = POI_TYPES.register(
            "teyvat_merchant",
            () -> new PoiType(
                    ImmutableSet.copyOf(ModBlocks.MORA_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1,
                    1
            )
    );

    public static final RegistryObject<VillagerProfession> TEYVAT_MERCHANT_PROFESSION = VILLAGER_PROFESSIONS.register(
            "teyvat_merchant",
            () -> new VillagerProfession(
                    "teyvat_merchant",
                    holder -> holder.value() == TEYVAT_MERCHANT_POI.get(),
                    holder -> holder.value() == TEYVAT_MERCHANT_POI.get(),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_FARMER
            )
    );

    private ModVillage() {
    }

    public static void register(IEventBus modEventBus) {
        POI_TYPES.register(modEventBus);
        VILLAGER_PROFESSIONS.register(modEventBus);
    }
}
