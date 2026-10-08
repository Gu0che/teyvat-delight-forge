package com.guoche.teyvatdelight.network;

import com.guoche.teyvatdelight.NutritionBagNetwork.Absorb;
import com.guoche.teyvatdelight.PortableNutritionBagItem;
import com.guoche.teyvatdelight.TeyvatDelight;
import java.util.Optional;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public final class NutritionBagNetwork {
    private static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TeyvatDelight.MODID, "nutrition_bag"), () -> "1", "1"::equals, "1"::equals);

    private NutritionBagNetwork() {
    }

    public static void register() {
        CHANNEL.registerMessage(0, Absorb.class, Absorb::encode, Absorb::decode, Absorb::handle,
                Optional.of(NetworkDirection.PLAY_TO_SERVER));
    }

    public static void sendAbsorb(int menuId, int slot) {
        CHANNEL.sendToServer(new Absorb(menuId, slot));
    }

    public static void handleAbsorb(ServerPlayer player, Absorb message) {
        AbstractContainerMenu menu = player.containerMenu;
        if (menu.containerId != message.menuId() || message.slot() < 0 || message.slot() >= menu.slots.size()) return;
        Slot slot = menu.getSlot(message.slot());
        ItemStack bag = menu.getCarried();
        ItemStack food = slot.getItem();
        if (!slot.mayPickup(player) || !slot.mayPlace(food)
                || !bag.is(TeyvatDelight.PORTABLE_NUTRITION_BAG.get()) || bag.getCount() != 1
                || food.isEmpty()) return;
        ItemStack remainder = PortableNutritionBagItem.containerFor(food);
        int count = food.getCount();
        if (!PortableNutritionBagItem.absorb(bag, food, player)) return;
        slot.set(ItemStack.EMPTY);
        slot.setChanged();
        menu.setCarried(bag.copy());
        if (!remainder.isEmpty()) giveContainers(player, remainder, count);
        menu.broadcastChanges();
        player.connection.send(new ClientboundContainerSetSlotPacket(-1, 0, -1, menu.getCarried().copy()));
        player.level().playSound(null, player.blockPosition(), SoundEvents.GENERIC_EAT,
                SoundSource.PLAYERS, 0.8F, 1.0F);
    }

    private static void giveContainers(ServerPlayer player, ItemStack remainder, int count) {
        long remaining = (long) remainder.getCount() * count;
        while (remaining > 0) {
            ItemStack stack = remainder.copy();
            stack.setCount((int) Math.min(remaining, remainder.getMaxStackSize()));
            remaining -= stack.getCount();
            player.getInventory().add(stack);
            if (!stack.isEmpty()) player.drop(stack, false);
        }
    }

    
}
