package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildFrostlampFlowerBlock extends WildTeyvatCropBlock {

    public WildFrostlampFlowerBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.FROSTLAMP_FLOWER,
                TeyvatDelight.FROSTLAMP_FLOWER_SEEDS,
                Surface.FROSTLAMP
        );
    }
}



