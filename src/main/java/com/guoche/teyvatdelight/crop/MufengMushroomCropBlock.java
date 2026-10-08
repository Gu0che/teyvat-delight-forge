package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatCropBlock;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.api.TeyvatTags;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MufengMushroomCropBlock extends TeyvatCropBlock {

    public MufengMushroomCropBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatTags.Blocks.NI_CI_ZHI_FIELDS,
                TeyvatDelight.MUFENG_MUSHROOM,
                TeyvatDelight.MUFENG_MUSHROOM_SPORES,
                7,
                1,
                0
        );
    }
}



