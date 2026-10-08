package com.guoche.teyvatdelight.client.katheryne;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.entity.katheryne.KatheryneSounds;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = TeyvatDelight.MODID, value = Dist.CLIENT)
public final class KatheryneVoiceEvents {
    private KatheryneVoiceEvents() {
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void replaceInteractionVoice(PlaySoundEvent event) {
        var sound = event.getSound();
        if (sound == null) return;
        KatheryneSounds.interruptPreviousVoice(sound.getLocation(), id -> event.getEngine().stop(id, null));
    }
}
