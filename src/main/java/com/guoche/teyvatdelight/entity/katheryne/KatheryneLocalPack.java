package com.guoche.teyvatdelight.entity.katheryne;

import com.guoche.teyvatdelight.TeyvatDelight;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod.EventBusSubscriber(modid = TeyvatDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class KatheryneLocalPack {
  private KatheryneLocalPack() {}

  @SubscribeEvent
  public static void packs(AddPackFindersEvent event) {
    if (event.getPackType() != PackType.SERVER_DATA) return;
    event.addRepositorySource(consumer -> {
      var path = FMLPaths.CONFIGDIR.get().resolve(KatheryneDataPack.PACK_DIRECTORY);
      var pack = Pack.readMetaAndCreate(
          "teyvatdelight/katheryne-local",
          Component.literal("凯瑟琳本地定义 / Katheryne local definitions"),
          true, id -> new PathPackResources(id, path, false),
          PackType.SERVER_DATA, Pack.Position.TOP, PackSource.DEFAULT);
      if (pack != null) consumer.accept(pack);
    });
  }
}
