package com.guoche.teyvatdelight.entity.katheryne;

import com.guoche.teyvatdelight.TeyvatDelight;
import java.util.function.Consumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class KatheryneSounds {
    private static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TeyvatDelight.MODID);

    public static final RegistryObject<SoundEvent> INTERACT = register("entity.katheryne.interact");
    public static final RegistryObject<SoundEvent> COMMISSION_COMPLETE =
            register("entity.katheryne.commission_complete");
    public static final RegistryObject<SoundEvent> IDLE_ANOMALY = register("entity.katheryne.idle_anomaly");

    private KatheryneSounds() {
    }

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(TeyvatDelight.MODID, name)));
    }

    public static void register(IEventBus modEventBus) {
        SOUNDS.register(modEventBus);
    }

    public static boolean interruptPreviousVoice(ResourceLocation nextSound, Consumer<ResourceLocation> stopSound) {
        ResourceLocation welcome = INTERACT.getId();
        ResourceLocation thanks = COMMISSION_COMPLETE.getId();
        if (!nextSound.equals(welcome) && !nextSound.equals(thanks)) return false;
        stopSound.accept(welcome);
        stopSound.accept(thanks);
        return true;
    }
}
