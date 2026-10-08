package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatCropBlock;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.api.TeyvatTags;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CallaLilyCropBlock extends TeyvatCropBlock {

    public CallaLilyCropBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatTags.Blocks.CHU_CI_ZHU_FIELDS,
                TeyvatDelight.CALLA_LILY,
                TeyvatDelight.CALLA_LILY_SEEDS
        );
    }
}



