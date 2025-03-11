package com.github.tacomonkey11.item;

import com.github.tacomonkey11.Lumberaxe;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import static com.github.tacomonkey11.Lumberaxe.MOD_ID;

public class LumberaxeItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> IRON_LUMBERAXE = register("iron_lumberaxe", ToolMaterial.IRON, 0, -3.1F);
    public static final RegistrySupplier<Item> GOLD_LUMBERAXE = register("gold_lumberaxe", ToolMaterial.GOLD, 2, -3.0F);
    public static final RegistrySupplier<Item> DIAMOND_LUMBERAXE = register("diamond_lumberaxe", ToolMaterial.DIAMOND, 3, -3.0F);
    public static final RegistrySupplier<Item> NETHERITE_LUMBERAXE = register("netherite_lumberaxe", ToolMaterial.NETHERITE, 4, -3.0F);

    private static RegistrySupplier<Item> register(String id, ToolMaterial material, float attackDamage, float attackSpeed) {
        return ITEMS.register(id, () -> new LumberaxeItem(material, attackDamage, attackSpeed, new Item.Properties().arch$tab(CreativeModeTabs.TOOLS_AND_UTILITIES).setId(ResourceKey.create(Registries.ITEM, Lumberaxe.id(id)))));
    }

    public static void register() {
        ITEMS.register();
    }
}
