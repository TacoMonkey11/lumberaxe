package com.github.tacomonkey11.lumberaxe;

import com.github.tacomonkey11.lumberaxe.config.LumberaxeConfig;
import com.github.tacomonkey11.lumberaxe.data.LumberaxeData;
import draylar.staticcontent.StaticContent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Lumberaxe implements ModInitializer {
        public static final LumberaxeConfig CONFIG = LumberaxeConfig.createAndLoad();
        public static final RegistryKey<ItemGroup> GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("lumberaxe", "group"));
        @Override
        public void onInitialize() {
                StaticContent.load(new Identifier("lumberaxe", "lumberaxes"), LumberaxeData.class);



                Registry.register(
                                Registries.ITEM_GROUP,
                                GROUP,
                                FabricItemGroup.builder()
                                                .displayName(Text.translatable("itemGroup.lumberaxe.group"))
                                                .icon(() -> Registries.ITEM.get(new Identifier("lumberaxe", "iron_lumberaxe")).getDefaultStack())
                                                .build()
                );
        }
}
