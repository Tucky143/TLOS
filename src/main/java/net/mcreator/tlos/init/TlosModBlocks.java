
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlos.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.tlos.block.LostWoodBlock;
import net.mcreator.tlos.block.LostStairsBlock;
import net.mcreator.tlos.block.LostSlabBlock;
import net.mcreator.tlos.block.LostPressurePlateBlock;
import net.mcreator.tlos.block.LostPlanksBlock;
import net.mcreator.tlos.block.LostLogBlock;
import net.mcreator.tlos.block.LostFenceGateBlock;
import net.mcreator.tlos.block.LostFenceBlock;
import net.mcreator.tlos.block.LostButtonBlock;
import net.mcreator.tlos.TlosMod;

public class TlosModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TlosMod.MODID);
	public static final DeferredBlock<Block> LOST_WOOD = REGISTRY.register("lost_wood", LostWoodBlock::new);
	public static final DeferredBlock<Block> LOST_LOG = REGISTRY.register("lost_log", LostLogBlock::new);
	public static final DeferredBlock<Block> LOST_PLANKS = REGISTRY.register("lost_planks", LostPlanksBlock::new);
	public static final DeferredBlock<Block> LOST_STAIRS = REGISTRY.register("lost_stairs", LostStairsBlock::new);
	public static final DeferredBlock<Block> LOST_SLAB = REGISTRY.register("lost_slab", LostSlabBlock::new);
	public static final DeferredBlock<Block> LOST_FENCE = REGISTRY.register("lost_fence", LostFenceBlock::new);
	public static final DeferredBlock<Block> LOST_FENCE_GATE = REGISTRY.register("lost_fence_gate", LostFenceGateBlock::new);
	public static final DeferredBlock<Block> LOST_PRESSURE_PLATE = REGISTRY.register("lost_pressure_plate", LostPressurePlateBlock::new);
	public static final DeferredBlock<Block> LOST_BUTTON = REGISTRY.register("lost_button", LostButtonBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
