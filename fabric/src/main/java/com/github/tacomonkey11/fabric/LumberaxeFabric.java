package com.github.tacomonkey11.fabric;

import com.github.tacomonkey11.Lumberaxe;
import net.fabricmc.api.ModInitializer;

public final class LumberaxeFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Lumberaxe.init();
    }
}
