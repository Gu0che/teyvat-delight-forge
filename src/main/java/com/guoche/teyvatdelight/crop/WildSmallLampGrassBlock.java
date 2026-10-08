package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildSmallLampGrassBlock extends WildTeyvatCropBlock {

    public WildSmallLampGrassBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.SMALL_LAMP_GRASS,
                TeyvatDelight.SMALL_LAMP_GRASS_SEEDS,
                Surface.GRASS_OR_DIRT
        );
    }
}



