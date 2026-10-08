package com.guoche.teyvatdelight.registry;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.block.KatheryneFigurineBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TeyvatDelight.MODID);
    public static final RegistryObject<BlockEntityType<KatheryneFigurineBlockEntity>> KATHERYNE_FIGURINE =
            BLOCK_ENTITY_TYPES.register("katheryne_figurine", () -> BlockEntityType.Builder.of(
                    KatheryneFigurineBlockEntity::new, ModBlocks.KATHERYNE_FIGURINE.get()).build(null));

    private ModBlockEntityTypes() {
    }

    public static void register(IEventBus bus) {
        BLOCK_ENTITY_TYPES.register(bus);
    }
}
