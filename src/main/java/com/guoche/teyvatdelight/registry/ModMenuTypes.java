package com.guoche.teyvatdelight.registry;

import com.guoche.teyvatdelight.KatheryneMenu;
import com.guoche.teyvatdelight.TeyvatDelight;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Owns menu type registrations; holders are resolved by deferred suppliers. */
public final class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TeyvatDelight.MODID);

    public static final RegistryObject<MenuType<KatheryneMenu>> KATHERYNE_MENU = MENUS.register(
            "katheryne", () -> new MenuType<>(KatheryneMenu::new, FeatureFlags.DEFAULT_FLAGS));

    private ModMenuTypes() {
    }

    public static void register(IEventBus modEventBus) {
        MENUS.register(modEventBus);
    }
}
