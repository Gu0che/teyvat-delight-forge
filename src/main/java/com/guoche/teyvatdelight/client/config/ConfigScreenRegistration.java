package com.guoche.teyvatdelight.client.config;

import com.guoche.teyvatdelight.TeyvatDelight;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.client.ConfigScreenHandler;

@EventBusSubscriber(modid = TeyvatDelight.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public final class ConfigScreenRegistration {
  private ConfigScreenRegistration() {}
  @SubscribeEvent
  public static void setup(FMLClientSetupEvent event) {
    if (!ModList.get().isLoaded("cloth_config")) return;
    ModList.get().getModContainerById(TeyvatDelight.MODID).orElseThrow()
        .registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class,
        () -> new ConfigScreenHandler.ConfigScreenFactory(
            parent -> KatheryneEditorScreens.open(parent, FMLPaths.CONFIGDIR.get())));
  }
}
