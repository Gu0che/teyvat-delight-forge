package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildDendrobiumBlock extends WildTeyvatCropBlock {

    public WildDendrobiumBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.DENDROBIUM,
                TeyvatDelight.DENDROBIUM_SEEDS,
                Surface.DENDROBIUM
        );
    }
}



