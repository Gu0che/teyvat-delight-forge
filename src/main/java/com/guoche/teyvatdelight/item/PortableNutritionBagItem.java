package com.guoche.teyvatdelight.item;

import com.guoche.teyvatdelight.PortableNutritionBagItem.Contents;
import com.guoche.teyvatdelight.api.TeyvatItemData;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class PortableNutritionBagItem extends Item {
    public static final int DEFAULT_STARS = 4;

    private static final String CONTENTS = "NutritionBag";
    private static final String CLEARING = "NutritionBagClearing";
    private static final int CLEAR_TICKS = 20;
    private static final int EAT_TICKS = 32;
    private static final int CLEAR_USE_DURATION = 72000;
    private static final int MAX_SERVINGS = 1_000_000;
    private static final FoodProperties EMPTY_FOOD = new FoodProperties.Builder()
            .nutrition(0).saturationMod(0.0F).build();

    public PortableNutritionBagItem(Properties properties) {
        super(properties);
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

    public static Contents contents(ItemStack stack) {
        CompoundTag root = stack.getTag();
        CompoundTag tag = root == null ? new CompoundTag() : root.getCompound(CONTENTS);
        int total = Math.max(0, tag.getInt("Total"));
        int remaining = Math.max(0, Math.min(total, tag.getInt("Remaining")));
        return new Contents(total, remaining, Math.max(0, tag.getLong("Nutrition")),
                Math.max(0.0D, tag.getDouble("Saturation")));
    }

    public static boolean isFilled(ItemStack stack) {
        return contents(stack).remaining() > 0;
    }

    public static boolean absorb(ItemStack bag, ItemStack food, Player player) {
        if (!(bag.getItem() instanceof PortableNutritionBagItem) || food.isEmpty() || food.is(bag.getItem())) return false;
        FoodProperties properties = food.getItem().getFoodProperties(food, player);
        if (properties == null) return false;
        Contents before = contents(bag);
        int count = food.getCount();
        if (count <= 0 || before.total() > MAX_SERVINGS - count) return false;
        Contents after = new Contents(before.total() + count, before.remaining() + count,
                before.nutrition() + (long) properties.getNutrition() * count,
                before.saturation() + (double) properties.getNutrition() * 2.0D
                        * properties.getSaturationModifier() * count);
        write(bag, after);
        return true;
    }

    public static ItemStack containerFor(ItemStack food) {
        return food.getCraftingRemainingItem();
    }

    private static void write(ItemStack stack, Contents contents) {
        CompoundTag root = stack.getOrCreateTag();
        if (contents.remaining() == 0) {
            root.remove(CONTENTS);
            root.remove("CustomModelData");
        } else {
            CompoundTag stored = new CompoundTag();
            stored.putInt("Total", contents.total());
            stored.putInt("Remaining", contents.remaining());
            stored.putLong("Nutrition", contents.nutrition());
            stored.putDouble("Saturation", contents.saturation());
            root.put(CONTENTS, stored);
            root.putInt("CustomModelData", 1);
        }
        if (root.isEmpty()) stack.setTag(null);
    }

    private static boolean clearing(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag != null && tag.getBoolean(CLEARING);
    }

    private static void setClearing(ItemStack stack, boolean clearing) {
        CompoundTag tag = stack.getOrCreateTag();
        if (clearing) tag.putBoolean(CLEARING, true);
        else tag.remove(CLEARING);
        if (tag.isEmpty()) stack.setTag(null);
    }

    @Override
    public FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity) {
        Contents stored = contents(stack);
        // Forge marks the whole item type edible; finish-event listeners also inspect the empty remainder.
        if (stored.remaining() == 0) return EMPTY_FOOD;
        int nutrition = stored.servingNutrition();
        int saturation = stored.servingSaturation();
        return new FoodProperties.Builder().nutrition(nutrition)
                .saturationMod(nutrition == 0 ? 0.0F : (float) saturation / (2.0F * nutrition)).build();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!isFilled(stack)) {
            setClearing(stack, false);
            return InteractionResultHolder.fail(stack);
        }
        if (player.isShiftKeyDown()) {
            setClearing(stack, true);
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(stack);
        }
        setClearing(stack, false);
        return super.use(level, player, hand);
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if (!(entity instanceof Player player)) return;
        if (!isFilled(stack)) {
            player.stopUsingItem();
            setClearing(stack, false);
            return;
        }
        if (!clearing(stack)) return;
        if (!player.isShiftKeyDown()) {
            player.stopUsingItem();
            setClearing(stack, false);
        } else if (CLEAR_USE_DURATION - remainingUseDuration >= CLEAR_TICKS) {
            player.stopUsingItem();
            setClearing(stack, false);
            if (!level.isClientSide()) {
                write(stack, new Contents(0, 0, 0, 0));
                level.playSound(null, player.blockPosition(), SoundEvents.SHULKER_SHOOT,
                        SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        setClearing(stack, false);
    }

    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int timeLeft) {
        setClearing(stack, false);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (clearing(stack) || !(entity instanceof Player player)) return stack;
        Contents stored = contents(stack);
        if (stored.remaining() == 0) return stack;
        if (!level.isClientSide()) {
            ItemStack serving = stack.copy();
            serving.setCount(1);
            player.eat(level, serving);
            write(stack, new Contents(stored.total(), stored.remaining() - 1,
                    stored.nutrition(), stored.saturation()));
        }
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        // Empty bags must stay unusable despite their non-null compatibility food properties.
        if (!isFilled(stack)) return 0;
        return clearing(stack) ? CLEAR_USE_DURATION : EAT_TICKS;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        if (!isFilled(stack)) return UseAnim.NONE;
        return clearing(stack) ? UseAnim.BOW : UseAnim.EAT;
    }

    public static void appendRemainingTooltip(ItemStack stack, List<Component> tooltip) {
        Contents stored = contents(stack);
        if (stored.remaining() == 0) return;
        tooltip.add(Math.min(1, tooltip.size()), Component.translatable(
                "item.teyvatdelight.portable_nutrition_bag.remaining",
                stored.remaining()));
    }

    
}
