package com.guoche.teyvatdelight.item;

import com.guoche.teyvatdelight.client.katheryne.KatheryneFigurineItemRenderer;
import com.guoche.teyvatdelight.api.TeyvatItemData;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import java.util.function.Consumer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public final class KatheryneFigurineBlockItem extends BlockItem {
    public static final int DEFAULT_STARS = 5;

    public KatheryneFigurineBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(
                TeyvatItemData.getStarColor(TeyvatItemData.getStars(stack, DEFAULT_STARS)));
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        TeyvatItemData.setStars(stack, DEFAULT_STARS);
        return stack;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        TeyvatItemData.appendRarityTooltip(stack, tooltip, DEFAULT_STARS);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(KatheryneFigurineItemRenderer.extensions());
    }
}
