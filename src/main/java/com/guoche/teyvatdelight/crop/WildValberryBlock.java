package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildValberryBlock extends WildTeyvatCropBlock {
    public WildValberryBlock(BlockBehaviour.Properties properties) {
        super(properties, TeyvatDelight.VALBERRY, TeyvatDelight.VALBERRY_SEEDS, Surface.GRASS_OR_DIRT);
    }
}

