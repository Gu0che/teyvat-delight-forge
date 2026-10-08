package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.WildTeyvatCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WildMintBlock extends WildTeyvatCropBlock {

    public WildMintBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatDelight.MINT,
                TeyvatDelight.MINT_SEEDS,
                Surface.ROCKY
        );
    }
}



