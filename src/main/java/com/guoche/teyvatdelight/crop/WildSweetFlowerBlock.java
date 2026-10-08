package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildSweetFlowerBlock extends WildTeyvatCropBlock {
    public WildSweetFlowerBlock(BlockBehaviour.Properties properties) {
        super(properties, TeyvatDelight.SWEET_FLOWER, TeyvatDelight.SWEET_FLOWER_SEEDS, Surface.ROCKY);
    }
}

