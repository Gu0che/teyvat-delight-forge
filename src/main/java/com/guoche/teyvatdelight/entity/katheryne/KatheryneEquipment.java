package com.guoche.teyvatdelight.entity.katheryne;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.ForgeRegistries;

public final class KatheryneEquipment {
    private KatheryneEquipment() {
    }

    public static ItemStack roll(ServerPlayer player, Item item) {
        ItemStack stack = new ItemStack(item);
        var settings = KatheryneShopConfig.settings().equipment();
        List<Enchantment> eligible = new ArrayList<>(ForgeRegistries.ENCHANTMENTS.getValues().stream()
                .filter(enchantment -> enchantment.canEnchant(stack))
                .filter(enchantment -> settings.allowCurses() || !enchantment.isCurse())
                .toList());
        RandomSource random = player.getRandom();
        List<Enchantment> selected = new ArrayList<>();
        double firstChance = settings.firstChance();
        double chanceStep = settings.chanceStep();
        while (!eligible.isEmpty()) {
            double chance = firstChance - selected.size() * chanceStep;
            if (chance <= 0 || random.nextDouble() >= chance) break;

            List<Enchantment> compatible = eligible.stream()
                    .filter(enchantment -> selected.stream().allMatch(enchantment::isCompatibleWith))
                    .toList();
            if (compatible.isEmpty()) break;
            Enchantment chosen = compatible.get(random.nextInt(compatible.size()));
            selected.add(chosen);
            eligible.remove(chosen);
        }
        for (Enchantment enchantment : selected) {
            int min = enchantment.getMinLevel();
            int max = enchantment.getMaxLevel();
            stack.enchant(enchantment, min + random.nextInt(max - min + 1));
        }
        return stack;
    }
}
