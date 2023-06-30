package com.github.tacomonkey11.lumberaxe.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;

@Config(name = "lumberaxe-config", wrapperName = "LumberaxeConfig")
@Modmenu(modId = "lumberaxe")
public class LumberaxeConfigModel {
        public int maxBroken = 100;
        public double durabilityMultiplier = 3.5;
}
