package com.guoche.teyvatdelight.food;

import com.guoche.teyvatdelight.api.TeyvatItemData;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class TeyvatDishItem extends ConsumableItem {
    private final ChatFormatting nameColor;
    private final int defaultStars;

    public TeyvatDishItem(Properties properties) {
        this(properties, null, 1);
    }

    public TeyvatDishItem(Properties properties, ChatFormatting nameColor) {
        this(properties, nameColor, 1);
    }

    public TeyvatDishItem(Properties properties, ChatFormatting nameColor, int defaultStars) {
        super(properties);
        this.nameColor = nameColor;
        this.defaultStars = TeyvatItemData.clampStars(defaultStars);
    }

    @Override
    public Component getName(ItemStack stack) {
        int stars = TeyvatItemData.getStars(stack, defaultStars);
        if (stars > 0) {
            return Component.translatable(this.getDescriptionId(stack)).withStyle(TeyvatItemData.getStarColor(stars));
        }

        if (nameColor != null) {
            return Component.translatable(this.getDescriptionId(stack)).withStyle(nameColor);
        }

        return super.getName(stack);
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        TeyvatItemData.setStars(stack, defaultStars);
        return stack;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        TeyvatItemData.appendRarityTooltip(stack, tooltip, defaultStars);
        TeyvatItemData.appendFoodQualityTooltip(stack, tooltip);
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public int getDefaultStars() {
        return defaultStars;
    }
}
