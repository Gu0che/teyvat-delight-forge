package com.guoche.teyvatdelight.integration.curios;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.guoche.teyvatdelight.TeyvatDelight;
import java.util.UUID;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import top.theillusivec4.caelus.api.CaelusApi;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public final class WindWingsCurios {
    // Caelus removes its own elytra modifier every tick when checking the chest slot.
    private static final AttributeModifier BACK_FLIGHT_MODIFIER = new AttributeModifier(
            UUID.fromString("52ff062b-45fc-4c12-bdeb-67c1a8fbce60"), "teyvatdelight:wind_wings_back",
            1.0D, AttributeModifier.Operation.ADDITION);

    private WindWingsCurios() {
    }

    public static void register(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> CuriosApi.registerCurio(TeyvatDelight.WIND_WINGS.get(), new ICurioItem() {
            @Override
            public boolean canEquip(SlotContext context, ItemStack stack) {
                return "back".equals(context.identifier());
            }

            @Override
            public void onEquip(SlotContext context, ItemStack previousStack, ItemStack stack) {
                updateFlightModifier(context, stack);
            }

            @Override
            public void curioTick(SlotContext context, ItemStack stack) {
                updateFlightModifier(context, stack);
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(
                    SlotContext context, UUID uuid, ItemStack stack) {
                if (!"back".equals(context.identifier()) || context.cosmetic()) {
                    return ImmutableMultimap.of();
                }
                CaelusApi caelus = CaelusApi.getInstance();
                return ImmutableMultimap.of(caelus.getFlightAttribute(), BACK_FLIGHT_MODIFIER);
            }
        }));
    }

    private static void updateFlightModifier(SlotContext context, ItemStack stack) {
        if (!"back".equals(context.identifier()) || context.cosmetic() || context.entity().level().isClientSide) {
            return;
        }
        AttributeInstance flight = context.entity().getAttribute(CaelusApi.getInstance().getFlightAttribute());
        if (flight == null) return;

        // Food changes do not change the equipped stack, so Curios will not recalculate its modifiers.
        if (stack.canElytraFly(context.entity())) {
            if (!flight.hasModifier(BACK_FLIGHT_MODIFIER)) flight.addTransientModifier(BACK_FLIGHT_MODIFIER);
        } else {
            flight.removeModifier(BACK_FLIGHT_MODIFIER.getId());
        }
    }

    public static ItemStack getBackWings(Player player) {
        return CuriosApi.getCuriosInventory(player)
                .map(handler -> handler.findFirstCurio(stack -> stack.is(TeyvatDelight.WIND_WINGS.get()))
                        .filter(result -> "back".equals(result.slotContext().identifier()))
                        .map(result -> result.stack()).orElse(ItemStack.EMPTY))
                .orElse(ItemStack.EMPTY);
    }
}
