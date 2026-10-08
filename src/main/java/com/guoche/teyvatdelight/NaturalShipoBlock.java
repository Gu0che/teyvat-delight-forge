package com.guoche.teyvatdelight;

import java.util.function.Supplier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

/** @deprecated Use {@link com.guoche.teyvatdelight.mineral.NaturalShipoBlock} for new integrations. */
@Deprecated
public class NaturalShipoBlock extends com.guoche.teyvatdelight.mineral.NaturalShipoBlock {
    public NaturalShipoBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public NaturalShipoBlock(
                BlockBehaviour.Properties properties,
                Supplier<? extends ItemLike> mineralItem,
                TagKey<Block> surfaceTag
        ) {
        super(properties, mineralItem, surfaceTag);
    }
}
