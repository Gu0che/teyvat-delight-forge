package com.guoche.teyvatdelight.harvest;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ToolActions;

public final class CollectionTools {
    private CollectionTools() {}

    public static boolean isPickaxe(ItemStack tool) {
        return tool.is(ItemTags.PICKAXES) || tool.canPerformAction(ToolActions.PICKAXE_DIG);
    }

    public static boolean isShears(ItemStack tool) {
        return tool.canPerformAction(ToolActions.SHEARS_DIG);
    }

    public static boolean hasSilkTouch(Level level, ItemStack tool) {
        return EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0;
    }
}
