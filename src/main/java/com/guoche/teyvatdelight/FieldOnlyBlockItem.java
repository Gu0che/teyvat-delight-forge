package com.guoche.teyvatdelight;

import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public class FieldOnlyBlockItem extends ItemNameBlockItem {
    private final TagKey<Block> fieldTag;

    public FieldOnlyBlockItem(Block block, TagKey<Block> fieldTag, Properties properties) {
        super(block, properties);
        this.fieldTag = fieldTag;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getClickedFace() != Direction.UP
                || !context.getLevel().getBlockState(context.getClickedPos()).is(this.fieldTag)) {
            return InteractionResult.FAIL;
        }

        return super.useOn(context);
    }
}
