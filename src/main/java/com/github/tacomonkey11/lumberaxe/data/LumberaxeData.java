package com.github.tacomonkey11.lumberaxe.data;

import com.github.tacomonkey11.lumberaxe.Lumberaxe;
import com.github.tacomonkey11.lumberaxe.item.LumberaxeItem;
import com.github.tacomonkey11.lumberaxe.material.LumberaxeToolMaterial;
import draylar.staticcontent.api.ContentData;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LumberaxeData implements ContentData {

        private final String id;
        private final int miningLevel;
        private final int durability;
        private final float miningSpeedMultiplier;
        private final float attackDamage;
        private final float attackSpeed;
        private final int enchantability;
        private final Identifier repairIngredient;
        private final boolean isFireImmune;
        private final int burnTime;

        public LumberaxeData(String id, int miningLevel, int durability, float miningSpeedMultiplier, float attackDamage, float attackSpeed, int enchantability, Identifier repairIngredient, boolean isFireImmune, int burnTime) {
                this.id = id;
                this.miningLevel = miningLevel;
                this.durability = durability;
                this.miningSpeedMultiplier = miningSpeedMultiplier;
                this.attackDamage = attackDamage;
                this.attackSpeed = attackSpeed;
                this.enchantability = enchantability;
                this.repairIngredient = repairIngredient;
                this.isFireImmune = isFireImmune;
                this.burnTime = burnTime;
        }

        @Override
        public void register(Identifier fileID) {
                Item.Settings settings = new Item.Settings().group(Lumberaxe.GROUP);
                if (isFireImmune()) {
                        settings.fireproof();
                }

                LumberaxeItem item = new LumberaxeItem(LumberaxeToolMaterial.from(this), getAttackDamage(), getAttackSpeed(), settings);

                if (getBurnTime() > 0) {
                        FuelRegistry.INSTANCE.add(item, getBurnTime());
                }

                Registry.register(
                                Registry.ITEM,
                                new Identifier("lumberaxe", id),
                                item
                                );
        }

        public float getAttackDamage() {
                return attackDamage;
        }

        public float getAttackSpeed() {
                return attackSpeed;
        }

        public float getMiningSpeedMultiplier() {
                return miningSpeedMultiplier;
        }

        public Identifier getRepairIngredient() {
                return repairIngredient;
        }

        public int getBurnTime() {
                return burnTime;
        }

        public int getDurability() {
                return durability;
        }

        public int getEnchantability() {
                return enchantability;
        }

        public int getMiningLevel() {
                return miningLevel;
        }

        public boolean isFireImmune() {
                return isFireImmune;
        }
}
