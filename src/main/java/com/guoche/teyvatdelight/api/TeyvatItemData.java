package com.guoche.teyvatdelight.api;

import com.guoche.teyvatdelight.PlaceableTeaItem;
import com.guoche.teyvatdelight.item.PortableNutritionBagItem;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.food.TeyvatDishItem;
import com.guoche.teyvatdelight.item.WindWingsItem;
import com.guoche.teyvatdelight.item.SeedDispensaryItem;
import com.guoche.teyvatdelight.item.KatheryneFigurineBlockItem;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

/**
 * Common accessors for data stored on individual ItemStacks.
 *
 * <p>Forge 1.20.1 does not have Minecraft 1.21's data components, so this
 * backport stores the same logical values in a namespaced NBT compound.</p>
 */
public final class TeyvatItemData {
    public static final int MIN_STARS = 1;
    public static final int MAX_STARS = 5;

    public static final String QUALITY_STRANGE = "strange";
    public static final String QUALITY_NORMAL = "normal";
    public static final String QUALITY_DELICIOUS = "delicious";

    private static final String ROOT_KEY = TeyvatDelight.MODID;
    private static final String STARS_KEY = "Stars";
    private static final String FOOD_QUALITY_KEY = "FoodQuality";

    private TeyvatItemData() {
    }

    public static int clampStars(int stars) {
        return Math.max(MIN_STARS, Math.min(MAX_STARS, stars));
    }

    /** Explicit stack override, or 0 when absent; unlike getDisplayStars, no item fallback. */
    public static int getStars(ItemStack stack) {
        CompoundTag tag = getTeyvatTag(stack);
        return tag != null && tag.contains(STARS_KEY, Tag.TAG_INT) ? clampStars(tag.getInt(STARS_KEY)) : 0;
    }

    public static int getStars(ItemStack stack, int fallbackStars) {
        int stars = getStars(stack);
        return stars > 0 ? stars : clampStars(fallbackStars);
    }

    /** Effective visual star rating: stack override, then the item's default, otherwise 0. */
    public static int getDisplayStars(ItemStack stack) {
        int stars = getStars(stack);
        if (stars > 0) {
            return stars;
        }

        if (stack.getItem() instanceof TeyvatDishItem dishItem) {
            return dishItem.getDefaultStars();
        }

        if (stack.getItem() instanceof PlaceableTeaItem) {
            return 1;
        }

        if (stack.getItem() instanceof WindWingsItem) {
            return WindWingsItem.DEFAULT_STARS;
        }

        if (stack.getItem() instanceof PortableNutritionBagItem) {
            return PortableNutritionBagItem.DEFAULT_STARS;
        }

        if (stack.getItem() instanceof SeedDispensaryItem) {
            return SeedDispensaryItem.DEFAULT_STARS;
        }

        if (stack.getItem() instanceof KatheryneFigurineBlockItem) {
            return KatheryneFigurineBlockItem.DEFAULT_STARS;
        }

        return 0;
    }

    /** Mutates only this stack; clamped to 1..5. Use clearStars to restore its item default. */
    public static void setStars(ItemStack stack, int stars) {
        getOrCreateTeyvatTag(stack).putInt(STARS_KEY, clampStars(stars));
    }

    /** Unknown or absent qualities read as normal; quality currently grants no gameplay bonuses. */
    public static String getFoodQuality(ItemStack stack) {
        CompoundTag tag = getTeyvatTag(stack);
        return tag != null && tag.contains(FOOD_QUALITY_KEY, Tag.TAG_STRING)
                ? normalizeQuality(tag.getString(FOOD_QUALITY_KEY))
                : QUALITY_NORMAL;
    }

    public static void setFoodQuality(ItemStack stack, String quality) {
        getOrCreateTeyvatTag(stack).putString(FOOD_QUALITY_KEY, normalizeQuality(quality));
    }

    /** Whether this stack explicitly stores a typed star override, even when equal to its default. */
    public static boolean hasStars(ItemStack stack) {
        CompoundTag tag = getTeyvatTag(stack);
        return tag != null && tag.contains(STARS_KEY, Tag.TAG_INT);
    }

    public static void clearStars(ItemStack stack) {
        removeValue(stack, STARS_KEY);
    }

    public static boolean hasFoodQuality(ItemStack stack) {
        CompoundTag tag = getTeyvatTag(stack);
        return tag != null && tag.contains(FOOD_QUALITY_KEY, Tag.TAG_STRING);
    }

    public static void clearFoodQuality(ItemStack stack) {
        removeValue(stack, FOOD_QUALITY_KEY);
    }

    private static void removeValue(ItemStack stack, String key) {
        CompoundTag tag = getTeyvatTag(stack);
        if (tag == null) return;
        tag.remove(key);
        if (tag.isEmpty()) {
            CompoundTag root = stack.getTag();
            root.remove(ROOT_KEY);
            if (root.isEmpty()) stack.setTag(null);
        }
    }

    public static String normalizeQuality(String quality) {
        if (QUALITY_STRANGE.equals(quality)
                || QUALITY_DELICIOUS.equals(quality)
                || QUALITY_NORMAL.equals(quality)) {
            return quality;
        }
        return QUALITY_NORMAL;
    }

    public static void appendRarityTooltip(ItemStack stack, List<Component> tooltip) {
        appendRarityTooltip(getStars(stack), tooltip);
    }

    public static void appendRarityTooltip(ItemStack stack, List<Component> tooltip, int fallbackStars) {
        appendRarityTooltip(getStars(stack, fallbackStars), tooltip);
    }

    private static void appendRarityTooltip(int stars, List<Component> tooltip) {
        if (stars > 0) {
            tooltip.add(Component.translatable(
                    "tooltip.teyvatdelight.stars",
                    buildStars(stars)
            ).withStyle(getStarColor(stars)));
        }
    }

    public static void appendFoodQualityTooltip(ItemStack stack, List<Component> tooltip) {
        CompoundTag tag = getTeyvatTag(stack);
        if (tag != null && tag.contains(FOOD_QUALITY_KEY, Tag.TAG_STRING)) {
            String quality = normalizeQuality(tag.getString(FOOD_QUALITY_KEY));
            if (!QUALITY_NORMAL.equals(quality)) {
                tooltip.add(Component.translatable("tooltip.teyvatdelight.food_quality." + quality));
            }
        }
    }

    public static String buildStars(int stars) {
        return "★".repeat(clampStars(stars));
    }

    public static ChatFormatting getStarColor(int stars) {
        return switch (clampStars(stars)) {
            case 5 -> ChatFormatting.GOLD;
            case 4 -> ChatFormatting.LIGHT_PURPLE;
            case 3 -> ChatFormatting.BLUE;
            case 2 -> ChatFormatting.GREEN;
            default -> ChatFormatting.WHITE;
        };
    }

    private static CompoundTag getTeyvatTag(ItemStack stack) {
        CompoundTag root = stack.getTag();
        return root != null && root.contains(ROOT_KEY, Tag.TAG_COMPOUND) ? root.getCompound(ROOT_KEY) : null;
    }

    private static CompoundTag getOrCreateTeyvatTag(ItemStack stack) {
        CompoundTag root = stack.getOrCreateTag();
        CompoundTag tag = root.contains(ROOT_KEY, Tag.TAG_COMPOUND)
                ? root.getCompound(ROOT_KEY)
                : new CompoundTag();
        root.put(ROOT_KEY, tag);
        return tag;
    }
}
