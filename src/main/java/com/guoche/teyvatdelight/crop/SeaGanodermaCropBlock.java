package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatCropBlock;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.api.TeyvatTags;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SeaGanodermaCropBlock extends TeyvatCropBlock {
    private static final int MATURE_LIGHT_LEVEL = 7;

    public SeaGanodermaCropBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatTags.Blocks.CHU_CI_ZHU_FIELDS,
                TeyvatDelight.SEA_GANODERMA,
                TeyvatDelight.SEA_GANODERMA_SAMPLE
        );
    }

    public static int getLightEmission(BlockState state) {
        return state.hasProperty(AGE) && state.getValue(AGE) >= 7 ? MATURE_LIGHT_LEVEL : 0;
    }
}



