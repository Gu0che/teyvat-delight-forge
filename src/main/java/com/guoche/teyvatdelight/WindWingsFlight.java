package com.guoche.teyvatdelight;

import net.minecraftforge.event.TickEvent;

/** @deprecated Use {@link com.guoche.teyvatdelight.item.WindWingsFlight} for new integrations. */
@Deprecated
public final class WindWingsFlight {
    private WindWingsFlight() {
    }

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        com.guoche.teyvatdelight.item.WindWingsFlight.onPlayerTick(event);
    }
}
