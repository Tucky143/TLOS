
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.tlom.block.LostWoodBlock;
import net.mcreator.tlom.block.LostStairsBlock;
import net.mcreator.tlom.block.LostSlabBlock;
import net.mcreator.tlom.block.LostPressurePlateBlock;
import net.mcreator.tlom.block.LostPlanksBlock;
import net.mcreator.tlom.block.LostLogBlock;
import net.mcreator.tlom.block.LostFenceGateBlock;
import net.mcreator.tlom.block.LostFenceBlock;
import net.mcreator.tlom.block.LostButtonBlock;
import net.mcreator.tlom.TlomMod;

public class TlomModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TlomMod.MODID);
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
