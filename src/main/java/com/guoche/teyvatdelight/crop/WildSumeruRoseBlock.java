package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildSumeruRoseBlock extends WildTeyvatCropBlock {

    public WildSumeruRoseBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.SUMERU_ROSE,
                TeyvatDelight.SUMERU_ROSE_SEEDS,
                Surface.GRASS_OR_DIRT
        );
    }
}



