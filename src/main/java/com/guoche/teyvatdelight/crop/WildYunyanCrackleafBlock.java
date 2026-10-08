package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildYunyanCrackleafBlock extends WildTeyvatCropBlock {

    public WildYunyanCrackleafBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.YUNYAN_LIEYE,
                TeyvatDelight.YUNYAN_LIEYE_SEEDS,
                Surface.STONE_OR_TERRACOTTA
        );
    }
}



