package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildRaspberryBlock extends WildTeyvatCropBlock {
    public WildRaspberryBlock(BlockBehaviour.Properties properties) {
        super(properties, TeyvatDelight.RASPBERRY, TeyvatDelight.RASPBERRY, Surface.GRASS_OR_DIRT);
    }
}

