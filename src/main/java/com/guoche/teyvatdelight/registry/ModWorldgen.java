package com.guoche.teyvatdelight.registry;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.TeyvatMineralPatchConfiguration;
import com.guoche.teyvatdelight.TeyvatMineralPatchFeature;
import com.guoche.teyvatdelight.WildTeyvatCropPatchConfiguration;
import com.guoche.teyvatdelight.WildTeyvatCropPatchFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Owns feature type registrations; holders are resolved by deferred suppliers. */
public final class ModWorldgen {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, TeyvatDelight.MODID);

    public static final RegistryObject<Feature<WildTeyvatCropPatchConfiguration>> WILD_CROP_PATCH_FEATURE = FEATURES.register(
            "wild_crop_patch",
            () -> new WildTeyvatCropPatchFeature(WildTeyvatCropPatchConfiguration.CODEC)
    );

    public static final RegistryObject<Feature<TeyvatMineralPatchConfiguration>> MINERAL_PATCH_FEATURE = FEATURES.register(
            "mineral_patch",
            () -> new TeyvatMineralPatchFeature(TeyvatMineralPatchConfiguration.CODEC)
    );

    private ModWorldgen() {
    }

    public static void register(IEventBus modEventBus) {
        FEATURES.register(modEventBus);
    }
}
