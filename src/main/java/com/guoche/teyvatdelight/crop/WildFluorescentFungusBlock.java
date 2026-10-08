package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildFluorescentFungusBlock extends WildTeyvatCropBlock {

    public WildFluorescentFungusBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.FLUORESCENT_FUNGUS,
                TeyvatDelight.FLUORESCENT_FUNGUS_SPORES,
                Surface.FLUORESCENT_FUNGUS
        );
    }
}



