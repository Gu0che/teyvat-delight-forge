package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildSnapdragonBlock extends WildTeyvatCropBlock {
    public WildSnapdragonBlock(BlockBehaviour.Properties properties) {
        super(properties, TeyvatDelight.SNAPDRAGON, TeyvatDelight.SNAPDRAGON_SEEDS, Surface.SAND_NEAR_WATER);
    }
}

