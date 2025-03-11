package com.github.tacomonkey11.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ToolMaterial;

public class LumberaxeItem extends AxeItem {
    public LumberaxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(new ToolMaterial(material.incorrectBlocksForDrops(), material.durability() * 3, material.speed(), material.attackDamageBonus(), material.enchantmentValue(), material.repairItems()), attackDamage, attackSpeed, properties);
    }
}
