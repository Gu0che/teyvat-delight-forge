package com.guoche.teyvatdelight;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

/** @deprecated Use {@link com.guoche.teyvatdelight.network.NutritionBagNetwork} for new integrations. */
@Deprecated
public final class NutritionBagNetwork {
    private NutritionBagNetwork() {
    }

    public static void register() {
        com.guoche.teyvatdelight.network.NutritionBagNetwork.register();
    }

    public static void sendAbsorb(int menuId, int slot) {
        com.guoche.teyvatdelight.network.NutritionBagNetwork.sendAbsorb(menuId, slot);
    }

    public record Absorb(int menuId, int slot) {
        public static void encode(Absorb message, FriendlyByteBuf buf) {
            buf.writeVarInt(message.menuId());
            buf.writeVarInt(message.slot());
        }

        public static Absorb decode(FriendlyByteBuf buf) {
            return new Absorb(buf.readVarInt(), buf.readVarInt());
        }

        public static void handle(Absorb message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                ServerPlayer player = context.getSender();
                if (player != null) com.guoche.teyvatdelight.network.NutritionBagNetwork.handleAbsorb(player, message);
            });
            context.setPacketHandled(true);
        }
    }
}
