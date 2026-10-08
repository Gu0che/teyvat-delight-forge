package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildWindwheelAsterBlock extends WildTeyvatCropBlock {

    public WildWindwheelAsterBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.WINDWHEEL_ASTER,
                TeyvatDelight.WINDWHEEL_ASTER_SEEDS,
                Surface.GRASS_OR_DIRT
        );
    }
}



