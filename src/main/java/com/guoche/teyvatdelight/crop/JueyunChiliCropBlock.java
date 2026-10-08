package com.guoche.teyvatdelight.crop;

import com.guoche.teyvatdelight.TeyvatCropBlock;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.api.TeyvatTags;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class JueyunChiliCropBlock extends TeyvatCropBlock {

    public JueyunChiliCropBlock(BlockBehaviour.Properties properties) {
        super(
                properties,
                TeyvatTags.Blocks.XUAN_CI_JADE_FIELDS,
                TeyvatDelight.JUEYUN_CHILI,
                TeyvatDelight.JUEYUN_CHILI_SEEDS,
                7,
                3,
                0
        );
    }
}



