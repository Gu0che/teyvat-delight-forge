package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatCropBlock;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.api.TeyvatTags;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class RaspberryCropBlock extends TeyvatCropBlock {
    public RaspberryCropBlock(BlockBehaviour.Properties properties) {
        super(properties, TeyvatTags.Blocks.XUAN_CI_JADE_FIELDS, TeyvatDelight.RASPBERRY, TeyvatDelight.RASPBERRY, 7, 3, 1);
    }

    @Override
    protected int getAgeAfterHarvest() {
        return 4;
    }

    @Override
    protected int getSeedCountOnBreak(BlockState state) {
        return this.isMaxAge(state) ? 0 : 1;
    }
}

