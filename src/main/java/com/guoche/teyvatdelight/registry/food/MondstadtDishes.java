package com.guoche.teyvatdelight.registry.food;

import com.guoche.teyvatdelight.TeyvatDishItem;
import com.guoche.teyvatdelight.registry.ModItems;
import java.util.List;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraftforge.registries.RegistryObject;

/** Mondstadt dishes from the approved dish sheet. */
public final class MondstadtDishes {
    public static final RegistryObject<TeyvatDishItem> THICK_CLOUD_PANCAKES = register("thick_cloud_pancakes", 7F, 6F, 2, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1800, 1));
    public static final RegistryObject<TeyvatDishItem> FISH_FLAVORED_TOAST = register("fish_flavored_toast", 6F, 6F, 2, null, false, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0));
    public static final RegistryObject<TeyvatDishItem> MAGICAL_MEAT_SAUCE_PASTA = register("magical_meat_sauce_pasta", 8F, 9.5F, 2, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), new MobEffectInstance(MobEffects.JUMP, 1200, 0));
    public static final RegistryObject<TeyvatDishItem> MANOR_PANCAKES = register("manor_pancakes", 6F, 5F, 2, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> FISHERMANS_TOAST = register("fishermans_toast", 5F, 5F, 2, null, false);
    public static final RegistryObject<TeyvatDishItem> FLAMING_RED_BOLOGNESE = register("flaming_red_bolognese", 7F, 8.5F, 2, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> ICED_WOLFHOOK_JUICE = register("iced_wolfhook_juice", 3F, 4F, 2, Items.GLASS_BOTTLE, true);
    public static final RegistryObject<TeyvatDishItem> BERRY_MINT_DRINK = register("berry_mint_drink", 3F, 4F, 2, Items.GLASS_BOTTLE, true);
    public static final RegistryObject<TeyvatDishItem> CREAMY_VEGETABLE_STEW = register("creamy_vegetable_stew", 7.5F, 9F, 2, Items.BOWL, false);
    public static final RegistryObject<TeyvatDishItem> SPICY_VEGETABLE_STEW = register("spicy_vegetable_stew", 8.5F, 10F, 2, Items.BOWL, false, new MobEffectInstance(MobEffects.REGENERATION, 1200, 1));
    public static final RegistryObject<TeyvatDishItem> SATISFYING_SALAD = register("satisfying_salad", 7.5F, 7.5F, 2, Items.BOWL, false);
    public static final RegistryObject<TeyvatDishItem> SUPREME_WISDOM_LIFE = register("supreme_wisdom_life", 8.5F, 8.5F, 2, Items.BOWL, false, new MobEffectInstance(MobEffects.LUCK, 10800, 0));
    public static final RegistryObject<TeyvatDishItem> FRIED_RADISH_BALLS = register("fried_radish_balls", 7.5F, 8F, 2, null, false);
    public static final RegistryObject<TeyvatDishItem> SWEET_MADAME = register("sweet_madame", 5.5F, 6.5F, 2, Items.BOWL, false);
    public static final RegistryObject<TeyvatDishItem> DINNERS_JUDGMENT = register("dinners_judgment", 6.5F, 7.5F, 2, Items.BOWL, false, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900, 1));
    public static final RegistryObject<TeyvatDishItem> SPARKLING_VALBERRY_JUICE = register("sparkling_valberry_juice", 3F, 4F, 2, Items.GLASS_BOTTLE, true);
    public static final RegistryObject<TeyvatDishItem> APPLE_CIDER = register("apple_cider", 4F, 4F, 2, Items.GLASS_BOTTLE, true);
    public static final RegistryObject<TeyvatDishItem> NORTHERN_SMOKED_CHICKEN = register("northern_smoked_chicken", 5F, 5.5F, 2, Items.BOWL, false);
    public static final RegistryObject<TeyvatDishItem> HEARTY_REVELRY = register("hearty_revelry", 6F, 6.5F, 2, Items.BOWL, false, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1), new MobEffectInstance(MobEffects.JUMP, 600, 3));
    public static final RegistryObject<TeyvatDishItem> RICH_VEGETABLE_STEW = register("rich_vegetable_stew", 8F, 9.5F, 2, Items.BOWL, false);
    public static final RegistryObject<TeyvatDishItem> CALLA_LILY_SEAFOOD_SOUP = register("calla_lily_seafood_soup", 5.5F, 6F, 3, Items.BOWL, false);
    public static final RegistryObject<TeyvatDishItem> HONEY_ROASTED_CARROTS_AND_MEAT = register("honey_roasted_carrots_and_meat", 8.5F, 9.5F, 3, Items.BOWL, false);
    public static final RegistryObject<TeyvatDishItem> BUTTER_MATSUTAKE = register("butter_matsutake", 6.5F, 7F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> COLD_CUT_PLATTER = register("cold_cut_platter", 9.5F, 14.5F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> BLESSED_SYMPHONY = register("blessed_symphony", 10.5F, 15.5F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0));
    public static final RegistryObject<TeyvatDishItem> MONDSTADT_HASH_BROWN = register("mondstadt_hash_brown", 6F, 7F, 3, null, false);
    public static final RegistryObject<TeyvatDishItem> PUPPY_PAW_HASH_BROWN = register("puppy_paw_hash_brown", 7F, 8F, 3, null, false, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0));
    public static final RegistryObject<TeyvatDishItem> ONCE_UPON_A_TIME_IN_MONDSTADT = register("once_upon_a_time_in_mondstadt", 10F, 12F, 3, Items.BOWL, false, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), new MobEffectInstance(MobEffects.NIGHT_VISION, 10800, 0));
    public static final RegistryObject<TeyvatDishItem> PILE_EM_UP = register("pile_em_up", 9F, 11F, 3, Items.BOWL, false);
    public static final RegistryObject<TeyvatDishItem> CRAB_ROE_HAM_BAKE = register("crab_roe_ham_bake", 9F, 13.5F, 3, Items.FLOWER_POT, false);
    public static final RegistryObject<TeyvatDishItem> NUTRITIOUS_MEAL_593 = register("nutritious_meal_593", 10F, 14.5F, 3, Items.FLOWER_POT, false, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 1), new MobEffectInstance(MobEffects.JUMP, 900, 1));
    public static final RegistryObject<TeyvatDishItem> MUSHROOM_PIZZA = register("mushroom_pizza", 5.5F, 6.5F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> INVIGORATING_PIZZA = register("invigorating_pizza", 7F, 8F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 900, 1), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 1));
    public static final RegistryObject<TeyvatDishItem> BARBATOS_RATATOUILLE = register("barbatos_ratatouille", 9F, 9.5F, 3, Items.BOWL, false);
    public static final RegistryObject<TeyvatDishItem> TRUE_BARBATOS_RATATOUILLE = register("true_barbatos_ratatouille", 10F, 10.5F, 3, Items.BOWL, false, new MobEffectInstance(MobEffects.JUMP, 900, 1), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 1), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900, 1), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 900, 1));
    public static final RegistryObject<TeyvatDishItem> HOLY_WATER = register("holy_water", 0F, 0F, 3, Items.GLASS_BOTTLE, true);
    public static final RegistryObject<TeyvatDishItem> BUTTER_FRIED_FISH = register("butter_fried_fish", 6.5F, 7F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> FOREST_DREAM = register("forest_dream", 7.5F, 8F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), new MobEffectInstance(MobEffects.JUMP, 1200, 0));
    public static final RegistryObject<TeyvatDishItem> HOLIDAY_FRUIT_BREW = register("holiday_fruit_brew", 4.5F, 5F, 3, Items.GLASS_BOTTLE, true);
    public static final RegistryObject<TeyvatDishItem> ADVENTURER_EGG_BURGER = register("adventurer_egg_burger", 9F, 12F, 3, null, false);
    public static final RegistryObject<TeyvatDishItem> SURVEYORS_EGG_BURGER = register("surveyors_egg_burger", 10F, 13F, 3, null, false, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 1), new MobEffectInstance(MobEffects.JUMP, 900, 1));
    public static final RegistryObject<TeyvatDishItem> WHIRLWIND_MEAT = register("whirlwind_meat", 8F, 10.5F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> APPLE_ROLL = register("apple_roll", 9F, 8F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> SHRIMP_POTATO_CUP = register("shrimp_potato_cup", 7F, 7.5F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> NIGHT_TALK = register("night_talk", 8F, 8.5F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false, new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0));
    public static final RegistryObject<TeyvatDishItem> NORTHERN_APPLE_STEW = register("northern_apple_stew", 8.5F, 9.5F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> FIRST_TRY_APPLE_STEW = register("first_try_apple_stew", 9.5F, 10.5F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900, 2));
    public static final RegistryObject<TeyvatDishItem> GOOD_MORNING_WINDMILL_TOWN = register("good_morning_windmill_town", 6F, 6.5F, 3, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> HARBOR_FISH_BURGER = register("harbor_fish_burger", 6.5F, 7F, 3, null, false);
    public static final RegistryObject<TeyvatDishItem> MINT_BUBBLE_GUM = register("mint_bubble_gum", 5.5F, 5.5F, 3, null, false);
    public static final RegistryObject<TeyvatDishItem> BOREDOM_BUBBLE_GUM = register("boredom_bubble_gum", 6.5F, 6.5F, 3, null, false, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 1), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900, 1));
    public static final RegistryObject<TeyvatDishItem> MOON_PIE = register("moon_pie", 8F, 9F, 4, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false);
    public static final RegistryObject<TeyvatDishItem> SURF_PIE = register("surf_pie", 9F, 10F, 4, Items.HEAVY_WEIGHTED_PRESSURE_PLATE, false, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 720, 2), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 720, 2));

    public static final List<RegistryObject<TeyvatDishItem>> ALL = List.of(
            THICK_CLOUD_PANCAKES,
            FISH_FLAVORED_TOAST,
            MAGICAL_MEAT_SAUCE_PASTA,
            MANOR_PANCAKES,
            FISHERMANS_TOAST,
            FLAMING_RED_BOLOGNESE,
            ICED_WOLFHOOK_JUICE,
            BERRY_MINT_DRINK,
            CREAMY_VEGETABLE_STEW,
            SPICY_VEGETABLE_STEW,
            SATISFYING_SALAD,
            SUPREME_WISDOM_LIFE,
            FRIED_RADISH_BALLS,
            SWEET_MADAME,
            DINNERS_JUDGMENT,
            SPARKLING_VALBERRY_JUICE,
            APPLE_CIDER,
            NORTHERN_SMOKED_CHICKEN,
            HEARTY_REVELRY,
            RICH_VEGETABLE_STEW,
            CALLA_LILY_SEAFOOD_SOUP,
            HONEY_ROASTED_CARROTS_AND_MEAT,
            BUTTER_MATSUTAKE,
            COLD_CUT_PLATTER,
            BLESSED_SYMPHONY,
            MONDSTADT_HASH_BROWN,
            PUPPY_PAW_HASH_BROWN,
            ONCE_UPON_A_TIME_IN_MONDSTADT,
            PILE_EM_UP,
            CRAB_ROE_HAM_BAKE,
            NUTRITIOUS_MEAL_593,
            MUSHROOM_PIZZA,
            INVIGORATING_PIZZA,
            BARBATOS_RATATOUILLE,
            TRUE_BARBATOS_RATATOUILLE,
            HOLY_WATER,
            BUTTER_FRIED_FISH,
            FOREST_DREAM,
            HOLIDAY_FRUIT_BREW,
            ADVENTURER_EGG_BURGER,
            SURVEYORS_EGG_BURGER,
            WHIRLWIND_MEAT,
            APPLE_ROLL,
            SHRIMP_POTATO_CUP,
            NIGHT_TALK,
            NORTHERN_APPLE_STEW,
            FIRST_TRY_APPLE_STEW,
            GOOD_MORNING_WINDMILL_TOWN,
            HARBOR_FISH_BURGER,
            MINT_BUBBLE_GUM,
            BOREDOM_BUBBLE_GUM,
            MOON_PIE,
            SURF_PIE
    );

    private MondstadtDishes() {}

    public static void init() {}

    private static RegistryObject<TeyvatDishItem> register(String id, float hungerIcons, float saturationIcons, int stars,
            Item container, boolean drink, MobEffectInstance... effects) {
        FoodProperties.Builder food = new FoodProperties.Builder()
                .nutrition(Math.round(hungerIcons * 2.0F))
                .saturationMod(hungerIcons == 0 ? 0 : saturationIcons / (hungerIcons * 2.0F));
        if (hungerIcons == 0) food.alwaysEat();
        for (MobEffectInstance effect : effects) food.effect(effect, 1.0F);
        
        Item.Properties properties = new Item.Properties().stacksTo(16).food(food.build());
        if (container != null) properties.craftRemainder(container);
        return ModItems.ITEMS.register(id, () -> new TeyvatDishItem(properties, null, stars) {
            @Override
            public UseAnim getUseAnimation(ItemStack stack) {
                return drink ? UseAnim.DRINK : super.getUseAnimation(stack);
            }
        });
    }
}
