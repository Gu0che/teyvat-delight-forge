package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatCropBlock;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.api.TeyvatTags;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class FluorescentFungusCropBlock extends TeyvatCropBlock {
    private static final int MATURE_LIGHT_LEVEL = 7;

    public FluorescentFungusCropBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatTags.Blocks.NI_CI_ZHI_FIELDS,
                TeyvatDelight.FLUORESCENT_FUNGUS,
                TeyvatDelight.FLUORESCENT_FUNGUS_SPORES
        );
    }

    public static int getLightEmission(BlockState state) {
        return state.hasProperty(AGE) && state.getValue(AGE) >= 7 ? MATURE_LIGHT_LEVEL : 0;
    }
}



