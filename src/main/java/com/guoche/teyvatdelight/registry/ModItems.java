package com.guoche.teyvatdelight.registry;

import com.guoche.teyvatdelight.FieldOnlyBlockItem;
import com.guoche.teyvatdelight.PortableNutritionBagItem;
import com.guoche.teyvatdelight.SeedDispensaryItem;
import com.guoche.teyvatdelight.StarconchItem;
import com.guoche.teyvatdelight.TeyvatDelight;
import com.guoche.teyvatdelight.api.TeyvatTags;
import com.guoche.teyvatdelight.WindWingsItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.KnifeItem;
import static com.guoche.teyvatdelight.food.FoodPropertiesHelper.dishFood;
import static com.guoche.teyvatdelight.food.FoodPropertiesHelper.dishFoodBuilder;
import static com.guoche.teyvatdelight.food.FoodPropertiesHelper.food;

/** Owns non-dish item registrations; holders are resolved by deferred suppliers. */
public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TeyvatDelight.MODID);

    public static final RegistryObject<BlockItem> XUAN_CI_JADE_FIELD_ITEM = registerSimpleBlockItem(
            "xuan_ci_jade_field",
            ModBlocks.XUAN_CI_JADE_FIELD
    );

    public static final RegistryObject<BlockItem> NI_CI_ZHI_FIELD_ITEM = registerSimpleBlockItem(
            "ni_ci_zhi_field",
            ModBlocks.NI_CI_ZHI_FIELD
    );

    public static final RegistryObject<BlockItem> CHU_CI_ZHU_FIELD_ITEM = registerSimpleBlockItem(
            "chu_ci_zhu_field",
            ModBlocks.CHU_CI_ZHU_FIELD
    );

    public static final RegistryObject<BlockItem> XUAN_CI_PU_FIELD_ITEM = registerSimpleBlockItem(
            "xuan_ci_pu_field",
            ModBlocks.XUAN_CI_PU_FIELD
    );

    public static final RegistryObject<BlockItem> NATURAL_SHIPO_ITEM = registerSimpleBlockItem(
            "natural_shipo",
            ModBlocks.NATURAL_SHIPO
    );

    public static final RegistryObject<BlockItem> NATURAL_YEBOSHI_ITEM = registerSimpleBlockItem(
            "natural_yeboshi",
            ModBlocks.NATURAL_YEBOSHI
    );

    public static final RegistryObject<BlockItem> NATURAL_DEEPSLATE_YEBOSHI_ITEM = registerSimpleBlockItem(
            "natural_deepslate_yeboshi",
            ModBlocks.NATURAL_DEEPSLATE_YEBOSHI
    );

    public static final RegistryObject<BlockItem> NATURAL_JINGHUAGUSUI_ITEM = registerSimpleBlockItem(
            "natural_jinghuagusui",
            ModBlocks.NATURAL_JINGHUAGUSUI
    );

    public static final RegistryObject<BlockItem> WILD_SMALL_LAMP_GRASS_ITEM = registerSimpleBlockItem(
            "wild_small_lamp_grass",
            ModBlocks.WILD_SMALL_LAMP_GRASS
    );

    public static final RegistryObject<BlockItem> WILD_WINDWHEEL_ASTER_ITEM = registerSimpleBlockItem(
            "wild_windwheel_aster",
            ModBlocks.WILD_WINDWHEEL_ASTER
    );

    public static final RegistryObject<BlockItem> WILD_CALLA_LILY_ITEM = registerSimpleBlockItem(
            "wild_calla_lily",
            ModBlocks.WILD_CALLA_LILY
    );

    public static final RegistryObject<BlockItem> WILD_MINT_ITEM = registerSimpleBlockItem(
            "wild_mint",
            ModBlocks.WILD_MINT
    );

    public static final RegistryObject<BlockItem> WILD_WOLFHOOK_ITEM = registerSimpleBlockItem(
            "wild_wolfhook",
            ModBlocks.WILD_WOLFHOOK
    );

    public static final RegistryObject<BlockItem> WILD_SNAPDRAGON_ITEM = registerSimpleBlockItem(
            "wild_snapdragon",
            ModBlocks.WILD_SNAPDRAGON
    );

    public static final RegistryObject<BlockItem> WILD_VALBERRY_ITEM = registerSimpleBlockItem(
            "wild_valberry",
            ModBlocks.WILD_VALBERRY
    );

    public static final RegistryObject<BlockItem> WILD_DANDELION_ITEM = registerSimpleBlockItem(
            "wild_dandelion",
            ModBlocks.WILD_DANDELION
    );

    public static final RegistryObject<BlockItem> WILD_CECILIA_ITEM = registerSimpleBlockItem(
            "wild_cecilia",
            ModBlocks.WILD_CECILIA
    );

    public static final RegistryObject<BlockItem> WILD_RASPBERRY_ITEM = registerSimpleBlockItem(
            "wild_raspberry",
            ModBlocks.WILD_RASPBERRY
    );

    public static final RegistryObject<BlockItem> WILD_SWEET_FLOWER_ITEM = registerSimpleBlockItem(
            "wild_sweet_flower",
            ModBlocks.WILD_SWEET_FLOWER
    );

    public static final RegistryObject<BlockItem> PINK_WINDBLUME_ITEM = registerSimpleBlockItem(
            "pink_windblume",
            ModBlocks.PINK_WINDBLUME
    );

    public static final RegistryObject<BlockItem> YELLOW_WINDBLUME_ITEM = registerSimpleBlockItem(
            "yellow_windblume",
            ModBlocks.YELLOW_WINDBLUME
    );

    public static final RegistryObject<BlockItem> PURPLE_WINDBLUME_ITEM = registerSimpleBlockItem(
            "purple_windblume",
            ModBlocks.PURPLE_WINDBLUME
    );

    public static final RegistryObject<BlockItem> WILD_JUEYUN_CHILI_ITEM = registerSimpleBlockItem(
            "wild_jueyun_chili",
            ModBlocks.WILD_JUEYUN_CHILI
    );

    public static final RegistryObject<BlockItem> WILD_GLAZE_LILY_ITEM = registerSimpleBlockItem(
            "wild_glaze_lily",
            ModBlocks.WILD_GLAZE_LILY
    );

    public static final RegistryObject<BlockItem> WILD_MUFENG_MUSHROOM_ITEM = registerSimpleBlockItem(
            "wild_mufeng_mushroom",
            ModBlocks.WILD_MUFENG_MUSHROOM
    );

    public static final RegistryObject<BlockItem> WILD_SUMERU_ROSE_ITEM = registerSimpleBlockItem(
            "wild_sumeru_rose",
            ModBlocks.WILD_SUMERU_ROSE
    );

    public static final RegistryObject<BlockItem> WILD_GRAINFRUIT_ITEM = registerSimpleBlockItem(
            "wild_grainfruit",
            ModBlocks.WILD_GRAINFRUIT
    );

    public static final RegistryObject<BlockItem> WILD_HORSETAIL_ITEM = registerSimpleBlockItem(
            "wild_horsetail",
            ModBlocks.WILD_HORSETAIL
    );

    public static final RegistryObject<BlockItem> WILD_JINXIN_FLOWER_ITEM = registerSimpleBlockItem(
            "wild_jinxin_flower",
            ModBlocks.WILD_JINXIN_FLOWER
    );

    public static final RegistryObject<BlockItem> WILD_FLUORESCENT_FUNGUS_ITEM = registerSimpleBlockItem(
            "wild_fluorescent_fungus",
            ModBlocks.WILD_FLUORESCENT_FUNGUS
    );

    public static final RegistryObject<BlockItem> WILD_SEA_GANODERMA_ITEM = registerSimpleBlockItem(
            "wild_sea_ganoderma",
            ModBlocks.WILD_SEA_GANODERMA
    );

    public static final RegistryObject<BlockItem> WILD_DENDROBIUM_ITEM = registerSimpleBlockItem(
            "wild_dendrobium",
            ModBlocks.WILD_DENDROBIUM
    );

    public static final RegistryObject<BlockItem> WILD_FROSTLAMP_FLOWER_ITEM = registerSimpleBlockItem(
            "wild_frostlamp_flower",
            ModBlocks.WILD_FROSTLAMP_FLOWER
    );

    public static final RegistryObject<Item> SMALL_LAMP_GRASS = registerSimpleItem(
            "small_lamp_grass",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> SMALL_LAMP_GRASS_SEEDS = ITEMS.register(
            "small_lamp_grass_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SMALL_LAMP_GRASS_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> WINDWHEEL_ASTER = registerSimpleItem(
            "windwheel_aster",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> WINDWHEEL_ASTER_SEEDS = ITEMS.register(
            "windwheel_aster_seeds",
            () -> new ItemNameBlockItem(ModBlocks.WINDWHEEL_ASTER_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> CALLA_LILY = registerSimpleItem(
            "calla_lily",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> CALLA_LILY_SEEDS = ITEMS.register(
            "calla_lily_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CALLA_LILY_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MINT = registerSimpleItem(
            "mint",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> MINT_SEEDS = ITEMS.register(
            "mint_seeds",
            () -> new ItemNameBlockItem(ModBlocks.MINT_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> WINDBLUME = registerSimpleItem(
            "windblume",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> WOLFHOOK = ITEMS.register(
            "wolfhook",
            () -> new ItemNameBlockItem(ModBlocks.WOLFHOOK_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> SNAPDRAGON = registerSimpleItem(
            "snapdragon",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> SNAPDRAGON_SEEDS = ITEMS.register(
            "snapdragon_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SNAPDRAGON_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> VALBERRY = registerSimpleItem(
            "valberry",
            new Item.Properties().food(dishFoodBuilder(1, 1.0F).fast().build())
    );

    public static final RegistryObject<ItemNameBlockItem> VALBERRY_SEEDS = ITEMS.register(
            "valberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.VALBERRY_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<ItemNameBlockItem> DANDELION_SEEDS = ITEMS.register(
            "dandelion_seeds",
            () -> new ItemNameBlockItem(ModBlocks.DANDELION_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> CECILIA = registerSimpleItem(
            "cecilia",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> CECILIA_SEEDS = ITEMS.register(
            "cecilia_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CECILIA_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<ItemNameBlockItem> RASPBERRY = ITEMS.register(
            "raspberry",
            () -> new ItemNameBlockItem(ModBlocks.RASPBERRY_CROP.get(), new Item.Properties().food(dishFoodBuilder(1, 0.5F).fast().build()))
    );

    public static final RegistryObject<Item> SWEET_FLOWER = registerSimpleItem(
            "sweet_flower",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> SWEET_FLOWER_SEEDS = ITEMS.register(
            "sweet_flower_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SWEET_FLOWER_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> JUEYUN_CHILI = registerSimpleItem(
            "jueyun_chili",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> JUEYUN_CHILI_SEEDS = ITEMS.register(
            "jueyun_chili_seeds",
            () -> new ItemNameBlockItem(ModBlocks.JUEYUN_CHILI_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> GLAZE_LILY = registerSimpleItem(
            "glaze_lily",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> GLAZE_LILY_SEEDS = ITEMS.register(
            "glaze_lily_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GLAZE_LILY_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> MUFENG_MUSHROOM = registerSimpleItem(
            "mufeng_mushroom",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> MUFENG_MUSHROOM_SPORES = ITEMS.register(
            "mufeng_mushroom_spores",
            () -> new ItemNameBlockItem(ModBlocks.MUFENG_MUSHROOM_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> SUMERU_ROSE = registerSimpleItem(
            "sumeru_rose",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> SUMERU_ROSE_SEEDS = ITEMS.register(
            "sumeru_rose_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SUMERU_ROSE_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> GRAINFRUIT = registerSimpleItem(
            "grainfruit",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> GRAINFRUIT_SEEDS = ITEMS.register(
            "grainfruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GRAINFRUIT_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> FLUORESCENT_FUNGUS = registerSimpleItem(
            "fluorescent_fungus",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> FLUORESCENT_FUNGUS_SPORES = ITEMS.register(
            "fluorescent_fungus_spores",
            () -> new ItemNameBlockItem(ModBlocks.FLUORESCENT_FUNGUS_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> SEA_GANODERMA = registerSimpleItem(
            "sea_ganoderma",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> SEA_GANODERMA_SAMPLE = ITEMS.register(
            "sea_ganoderma_sample",
            () -> new ItemNameBlockItem(ModBlocks.SEA_GANODERMA_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> DENDROBIUM = registerSimpleItem(
            "dendrobium",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> DENDROBIUM_SEEDS = ITEMS.register(
            "dendrobium_seeds",
            () -> new ItemNameBlockItem(ModBlocks.DENDROBIUM_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> FROSTLAMP_FLOWER = registerSimpleItem(
            "frostlamp_flower",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> FROSTLAMP_FLOWER_SEEDS = ITEMS.register(
            "frostlamp_flower_seeds",
            () -> new ItemNameBlockItem(ModBlocks.FROSTLAMP_FLOWER_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> YUNYAN_LIEYE = registerSimpleItem(
            "yunyan_lieye",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> YUNYAN_LIEYE_SEEDS = ITEMS.register(
            "yunyan_lieye_seeds",
            () -> new ItemNameBlockItem(ModBlocks.YUNYAN_LIEYE_CROP.get(), new Item.Properties())
    );

    public static final RegistryObject<BlockItem> WILD_YUNYAN_LIEYE_ITEM = registerSimpleBlockItem(
            "wild_yunyan_lieye",
            ModBlocks.WILD_YUNYAN_LIEYE
    );

    public static final RegistryObject<ItemNameBlockItem> CORAL_SHELL = ITEMS.register(
            "coral_shell",
            () -> new FieldOnlyBlockItem(ModBlocks.GROWING_CORAL_SHELL.get(), TeyvatTags.Blocks.CHU_CI_ZHU_FIELDS, new Item.Properties())
    );

    public static final RegistryObject<Item> CORAL_PEARL = registerSimpleItem(
            "coral_pearl",
            new Item.Properties()
    );

    public static final RegistryObject<BlockItem> NATURAL_CORAL_PEARL_ITEM = registerSimpleBlockItem(
            "natural_coral_pearl",
            ModBlocks.NATURAL_CORAL_PEARL
    );

    public static final RegistryObject<Item> HORSETAIL = registerSimpleItem(
            "horsetail",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> HORSETAIL_SEEDS = ITEMS.register(
            "horsetail_seeds",
            () -> new ItemNameBlockItem(ModBlocks.HORSETAIL_BOTTOM.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> JINXIN_FLOWER = registerSimpleItem(
            "jinxin_flower",
            new Item.Properties()
    );

    public static final RegistryObject<ItemNameBlockItem> JINXIN_FLOWER_BUD = ITEMS.register(
            "jinxin_flower_bud",
            () -> new FieldOnlyBlockItem(ModBlocks.THIRSTING_JINXIN_FLOWER.get(), TeyvatTags.Blocks.XUAN_CI_JADE_FIELDS, new Item.Properties())
    );

    public static final RegistryObject<Item> PEPPER = registerSimpleItem(
            "pepper",
            new Item.Properties()
    );

    public static final RegistryObject<Item> SALT = registerSimpleItem(
            "salt",
            new Item.Properties()
    );

    public static final RegistryObject<Item> CHENYU_TEA = registerSimpleItem(
            "chenyu_tea",
            new Item.Properties()
    );

    public static final RegistryObject<Item> TOFU = registerSimpleItem(
            "tofu",
            new Item.Properties()
    );

    public static final RegistryObject<Item> GLABROUS_BEANS = registerSimpleItem(
            "glabrous_beans",
            new Item.Properties()
    );

    public static final RegistryObject<Item> SHRIMP_MEAT = registerSimpleItem(
            "shrimp_meat",
            new Item.Properties()
    );

    public static final RegistryObject<Item> ALMOND = registerSimpleItem(
            "almond",
            new Item.Properties()
    );

    public static final RegistryObject<Item> MATSUTAKE = registerSimpleItem(
            "matsutake",
            new Item.Properties()
    );

    public static final RegistryObject<Item> CRAB = registerSimpleItem(
            "crab",
            new Item.Properties()
    );

    public static final RegistryObject<Item> SAUSAGE = registerSimpleItem(
            "sausage",
            new Item.Properties()
    );

    public static final RegistryObject<Item> JAM = registerSimpleItem(
            "jam",
            new Item.Properties()
    );

    public static final RegistryObject<Item> BUTTER = registerSimpleItem(
            "butter",
            new Item.Properties()
    );

    public static final RegistryObject<Item> CHEESE = registerSimpleItem(
            "cheese",
            new Item.Properties().food(dishFood(3, 3.5F))
    );

    public static final RegistryObject<Item> CREAM = registerSimpleItem(
            "cream",
            new Item.Properties()
    );

    public static final RegistryObject<Item> SUNSETTIA = registerSimpleItem(
            "sunsettia",
            new Item.Properties().food(dishFood(2, 2.0F))
    );

    public static final RegistryObject<Item> PINECONE = registerSimpleItem(
            "pinecone",
            new Item.Properties()
    );

    public static final RegistryObject<Item> CRAB_ROE = registerSimpleItem(
            "crab_roe",
            new Item.Properties()
    );

    public static final RegistryObject<Item> SMOKED_FOWL = registerSimpleItem(
            "smoked_fowl",
            new Item.Properties().food(dishFood(3, 3.5F))
    );

    public static final RegistryObject<Item> MORA = registerSimpleItem(
            "mora",
            new Item.Properties()
    );

    public static final RegistryObject<Item> PRIMOGEM = registerSimpleItem(
            "primogem",
            new Item.Properties()
    );

    public static final RegistryObject<BlockItem> PRIMOGEM_BLOCK_ITEM = registerSimpleBlockItem(
            "primogem_block",
            ModBlocks.PRIMOGEM_BLOCK
    );

    public static final RegistryObject<BlockItem> MORA_BLOCK_ITEM = registerSimpleBlockItem(
            "mora_block",
            ModBlocks.MORA_BLOCK
    );

    public static final RegistryObject<StarconchItem> STARCONCH_ITEM = ITEMS.register(
            "starconch",
            () -> new StarconchItem(new Item.Properties())
    );

    public static final RegistryObject<Item> EMPTY_FEATHER_MOTH_ITEM = ITEMS.register(
            "empty_feather_moth", () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<ForgeSpawnEggItem> EMPTY_FEATHER_MOTH_SPAWN_EGG = ITEMS.register(
            "empty_feather_moth_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.EMPTY_FEATHER_MOTH, 0xEDC078, 0xFFF1B8, new Item.Properties())
    );

    public static final RegistryObject<ForgeSpawnEggItem> KATHERYNE_SPAWN_EGG = ITEMS.register(
            "katheryne_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KATHERYNE, 0x333D43, 0xDFC89B, new Item.Properties())
    );

    private static final Tier PRIMOGEM_KNIFE_TIER = new Tier() {
        @Override
        public int getUses() {
            return Tiers.NETHERITE.getUses();
        }

        @Override
        public float getSpeed() {
            return Tiers.NETHERITE.getSpeed();
        }

        @Override
        public float getAttackDamageBonus() {
            return Tiers.NETHERITE.getAttackDamageBonus();
        }

        @Override
        public int getLevel() {
            return Tiers.NETHERITE.getLevel();
        }

        @Override
        public int getEnchantmentValue() {
            return Tiers.NETHERITE.getEnchantmentValue();
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(PRIMOGEM.get());
        }
    };

    public static final RegistryObject<KnifeItem> PRIMOGEM_KNIFE = ITEMS.register(
            "primogem_knife",
            () -> new KnifeItem(
                    PRIMOGEM_KNIFE_TIER,
                    1.0F,
                    -2.0F,
                    new Item.Properties()
            )
    );

    public static final RegistryObject<ItemNameBlockItem> SHIPO = ITEMS.register(
            "shipo",
            () -> new ItemNameBlockItem(ModBlocks.BURIED_SHIPO_FRAGMENT.get(), new Item.Properties())
    );

    public static final RegistryObject<ItemNameBlockItem> JINGHUAGUSUI = ITEMS.register(
            "jinghuagusui",
            () -> new ItemNameBlockItem(ModBlocks.BURIED_JINGHUAGUSUI_FRAGMENT.get(), new Item.Properties())
    );

    public static final RegistryObject<ItemNameBlockItem> YEBOSHI = ITEMS.register(
            "yeboshi",
            () -> new ItemNameBlockItem(ModBlocks.BURIED_YEBOSHI_FRAGMENT.get(), new Item.Properties())
    );

    public static final RegistryObject<SeedDispensaryItem> SEED_DISPENSARY = ITEMS.register(
            "seed_dispensary",
            () -> new SeedDispensaryItem(new Item.Properties().stacksTo(1))
    );

    public static final RegistryObject<WindWingsItem> WIND_WINGS = ITEMS.register(
            "wind_wings",
            () -> new WindWingsItem(new Item.Properties().stacksTo(1))
    );

    public static final RegistryObject<PortableNutritionBagItem> PORTABLE_NUTRITION_BAG = ITEMS.register(
            "portable_nutrition_bag",
            () -> new PortableNutritionBagItem(new Item.Properties().stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0).build()))
    );

    private static RegistryObject<Item> registerSimpleItem(String name, Item.Properties properties) {
        return ITEMS.register(name, () -> new Item(properties));
    }

    private static <T extends Block> RegistryObject<BlockItem> registerSimpleBlockItem(String name, RegistryObject<T> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static final RegistryObject<BlockItem> KATHERYNE_FIGURINE_ITEM = ITEMS.register(
            "katheryne_figurine", () -> new com.guoche.teyvatdelight.item.KatheryneFigurineBlockItem(
                    ModBlocks.KATHERYNE_FIGURINE.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> SLOW_FALLING_ADVANCEMENT_ICON = ITEMS.register("slow_falling_advancement_icon", () -> new Item(new Item.Properties()));

    private ModItems() {
    }

    public static void register(IEventBus modEventBus) {
        ModFoods.init();
        ITEMS.register(modEventBus);
    }
}
