package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatCropBlock;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.api.TeyvatTags;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GrainfruitCropBlock extends TeyvatCropBlock {

    public GrainfruitCropBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatTags.Blocks.XUAN_CI_JADE_FIELDS,
                TeyvatDelight.GRAINFRUIT,
                TeyvatDelight.GRAINFRUIT_SEEDS,
                7,
                1,
                0
        );
    }
}



