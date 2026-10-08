package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildCeciliaBlock extends WildTeyvatCropBlock {
    public WildCeciliaBlock(BlockBehaviour.Properties properties) {
        super(properties, TeyvatDelight.CECILIA, TeyvatDelight.CECILIA_SEEDS, Surface.GRASS_OR_DIRT);
    }
}

