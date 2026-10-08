package com.guoche.teyvatdelight;

import net.minecraftforge.common.ForgeConfigSpec;

/** @deprecated Use the config package for new integrations. */
@Deprecated
public final class TeyvatDelightConfig {
    public static final ForgeConfigSpec SPEC = com.guoche.teyvatdelight.config.TeyvatDelightConfig.SPEC;
    public static final ForgeConfigSpec.BooleanValue COUNTRY_CHALLENGE_WIND_WINGS = com.guoche.teyvatdelight.config.TeyvatDelightConfig.COUNTRY_CHALLENGE_WIND_WINGS;
    public static final ForgeConfigSpec.BooleanValue PRIMOGEMS_IN_CHESTS = com.guoche.teyvatdelight.config.TeyvatDelightConfig.PRIMOGEMS_IN_CHESTS;

    private TeyvatDelightConfig() {
    }
}
