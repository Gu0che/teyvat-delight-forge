package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatCropBlock;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.api.TeyvatTags;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SumeruRoseCropBlock extends TeyvatCropBlock {

    public SumeruRoseCropBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatTags.Blocks.XUAN_CI_JADE_FIELDS,
                TeyvatDelight.SUMERU_ROSE,
                TeyvatDelight.SUMERU_ROSE_SEEDS,
                4,
                1,
                0
        );
    }
}



