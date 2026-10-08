package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildGrainfruitBlock extends WildTeyvatCropBlock {

    public WildGrainfruitBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.GRAINFRUIT,
                TeyvatDelight.GRAINFRUIT_SEEDS,
                Surface.GRAINFRUIT
        );
    }
}



