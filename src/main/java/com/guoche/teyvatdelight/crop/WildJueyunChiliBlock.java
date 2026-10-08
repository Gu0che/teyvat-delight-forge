package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildJueyunChiliBlock extends WildTeyvatCropBlock {

    public WildJueyunChiliBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.JUEYUN_CHILI,
                TeyvatDelight.JUEYUN_CHILI_SEEDS,
                Surface.ROCKY
        );
    }
}



