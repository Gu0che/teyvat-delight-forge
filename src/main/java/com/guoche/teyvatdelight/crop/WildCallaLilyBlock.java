package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildCallaLilyBlock extends WildTeyvatCropBlock {

    public WildCallaLilyBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.CALLA_LILY,
                TeyvatDelight.CALLA_LILY_SEEDS,
                Surface.SAND_NEAR_WATER
        );
    }
}



