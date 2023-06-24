package com.github.tacomonkey11.lumberaxe;

import com.github.tacomonkey11.lumberaxe.config.LumberaxeConfig;
import com.github.tacomonkey11.lumberaxe.data.LumberaxeData;
import draylar.staticcontent.StaticContent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Lumberaxe implements ModInitializer {

        public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier("lumberaxe", "group"), () -> new ItemStack(Registry.ITEM.get(new Identifier("lumberaxe", "iron_lumberaxe"))));
        public static final LumberaxeConfig CONFIG = LumberaxeConfig.createAndLoad();
        @Override
        public void onInitialize() {
                StaticContent.load(new Identifier("lumberaxe", "lumberaxes"), LumberaxeData.class);
        }
}
