package com.guoche.teyvatdelight.food;

import com.guoche.teyvatdelight.api.TeyvatItemData;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.utility.TextUtils;

public class PlaceableTeaItem extends BlockItem {
    public PlaceableTeaItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return context.getPlayer() != null && context.getPlayer().isShiftKeyDown()
                ? place(new BlockPlaceContext(context)) : InteractionResult.PASS;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public String getDescriptionId() {
        return "item.teyvatdelight.chenyu_tea_brew";
    }

    @Override
    public Component getName(ItemStack stack) {
        int stars = TeyvatItemData.getStars(stack, 1);
        return Component.translatable(getDescriptionId(stack)).withStyle(TeyvatItemData.getStarColor(stars));
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        TeyvatItemData.setStars(stack, 1);
        return stack;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        TeyvatItemData.appendRarityTooltip(stack, tooltip, 1);
        TeyvatItemData.appendFoodQualityTooltip(stack, tooltip);
        if (Configuration.ENABLE_FOOD_EFFECT_TOOLTIP.get()) {
            TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
        }
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack container = stack.getCraftingRemainingItem();
        ItemStack remaining = super.finishUsingItem(stack, level, entity);
        if (!(entity instanceof Player player) || player.getAbilities().instabuild) return remaining;
        if (remaining.isEmpty()) return container;
        if (!level.isClientSide && !player.getInventory().add(container.copy())) {
            player.drop(container, false);
        }
        return remaining;
    }
}
