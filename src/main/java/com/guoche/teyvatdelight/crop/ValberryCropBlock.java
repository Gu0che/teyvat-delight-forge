package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatCropBlock;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.api.TeyvatTags;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ValberryCropBlock extends TeyvatCropBlock {
    public ValberryCropBlock(BlockBehaviour.Properties properties) {
        super(properties, TeyvatTags.Blocks.XUAN_CI_JADE_FIELDS, TeyvatDelight.VALBERRY, TeyvatDelight.VALBERRY_SEEDS, 7, 4, 1);
    }

    @Override
    protected int getAgeAfterHarvest() {
        return 5;
    }
}

