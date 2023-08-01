package com.github.tacomonkey11.lumberaxe.item;

import com.github.tacomonkey11.lumberaxe.Lumberaxe;
import io.netty.util.internal.IntegerHolder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LumberaxeItem extends AxeItem {
        public LumberaxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
        }

        @Override
        public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {

                if (miner.isSneaking() || !state.getMaterial().equals(Material.WOOD)) return super.postMine(stack, world, state, pos, miner);

                IntegerHolder integerHolder = new IntegerHolder();

                integerHolder.value = 0;

                mineTree(pos, world, stack, miner, integerHolder);

                return super.postMine(stack, world, state, pos, miner);

        }

        public void mineTree(BlockPos pos, World world, ItemStack stack, LivingEntity miner, IntegerHolder holder){
                if (holder.value >= Lumberaxe.CONFIG.maxBroken()) return;

                if (world.getBlockState(pos).isIn(BlockTags.LOGS)) {
                        world.breakBlock(pos, true, miner);
                        stack.damage(1, miner, (e) -> e.sendToolBreakStatus(miner.getActiveHand()));
                        if (miner instanceof PlayerEntity) {
                                ((PlayerEntity) miner).addExhaustion(0.2F);
                        }
                        holder.value++;
                }

                for (BlockPos blockPos : BlockPos.iterateOutwards(pos, 1, 1, 1)) {
                        if (world.getBlockState(blockPos).isIn(BlockTags.LOGS)) {
                                mineTree(blockPos, world, stack, miner, holder);
                        }
                }
        }
}
