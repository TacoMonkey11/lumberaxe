package com.github.tacomonkey11.lumberaxe;

import com.github.tacomonkey11.lumberaxe.config.LumberaxeConfig;
import com.github.tacomonkey11.lumberaxe.data.LumberaxeData;
import draylar.staticcontent.StaticContent;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Lumberaxe implements ModInitializer {
        public static final LumberaxeConfig CONFIG = LumberaxeConfig.createAndLoad();
        @Override
        public void onInitialize() {
                StaticContent.load(new Identifier("lumberaxe", "lumberaxes"), LumberaxeData.class);
        }
}
