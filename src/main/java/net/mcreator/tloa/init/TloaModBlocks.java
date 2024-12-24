
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tloa.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.tloa.block.SheikahPlateBlock;
import net.mcreator.tloa.block.SheikahLightBlock;
import net.mcreator.tloa.block.SheikahGrateWallBlock;
import net.mcreator.tloa.block.SheikahGrateBlock;
import net.mcreator.tloa.block.LostWoodBlock;
import net.mcreator.tloa.block.LostStairsBlock;
import net.mcreator.tloa.block.LostSlabBlock;
import net.mcreator.tloa.block.LostPressurePlateBlock;
import net.mcreator.tloa.block.LostPlanksBlock;
import net.mcreator.tloa.block.LostLogBlock;
import net.mcreator.tloa.block.LostFenceGateBlock;
import net.mcreator.tloa.block.LostFenceBlock;
import net.mcreator.tloa.block.LostButtonBlock;
import net.mcreator.tloa.block.GlowingSheikahPlateBlock;
import net.mcreator.tloa.block.GlowingChiseledSheikahPlateBlock;
import net.mcreator.tloa.block.DesignedSheikahPlateBlock;
import net.mcreator.tloa.block.DekuWoodBlock;
import net.mcreator.tloa.block.DekuStairsBlock;
import net.mcreator.tloa.block.DekuSlabBlock;
import net.mcreator.tloa.block.DekuPressurePlateBlock;
import net.mcreator.tloa.block.DekuPlanksBlock;
import net.mcreator.tloa.block.DekuLogBlock;
import net.mcreator.tloa.block.DekuLeavesBlock;
import net.mcreator.tloa.block.DekuFenceGateBlock;
import net.mcreator.tloa.block.DekuFenceBlock;
import net.mcreator.tloa.block.DekuButtonBlock;
import net.mcreator.tloa.block.ChiseledSheikahPlateBlock;
import net.mcreator.tloa.TloaMod;

public class TloaModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TloaMod.MODID);
	public static final DeferredBlock<Block> LOST_WOOD = REGISTRY.register("lost_wood", LostWoodBlock::new);
	public static final DeferredBlock<Block> LOST_LOG = REGISTRY.register("lost_log", LostLogBlock::new);
	public static final DeferredBlock<Block> LOST_PLANKS = REGISTRY.register("lost_planks", LostPlanksBlock::new);
	public static final DeferredBlock<Block> LOST_STAIRS = REGISTRY.register("lost_stairs", LostStairsBlock::new);
	public static final DeferredBlock<Block> LOST_SLAB = REGISTRY.register("lost_slab", LostSlabBlock::new);
	public static final DeferredBlock<Block> LOST_FENCE = REGISTRY.register("lost_fence", LostFenceBlock::new);
	public static final DeferredBlock<Block> LOST_FENCE_GATE = REGISTRY.register("lost_fence_gate", LostFenceGateBlock::new);
	public static final DeferredBlock<Block> LOST_PRESSURE_PLATE = REGISTRY.register("lost_pressure_plate", LostPressurePlateBlock::new);
	public static final DeferredBlock<Block> LOST_BUTTON = REGISTRY.register("lost_button", LostButtonBlock::new);
	public static final DeferredBlock<Block> DEKU_WOOD = REGISTRY.register("deku_wood", DekuWoodBlock::new);
	public static final DeferredBlock<Block> DEKU_LOG = REGISTRY.register("deku_log", DekuLogBlock::new);
	public static final DeferredBlock<Block> DEKU_PLANKS = REGISTRY.register("deku_planks", DekuPlanksBlock::new);
	public static final DeferredBlock<Block> DEKU_LEAVES = REGISTRY.register("deku_leaves", DekuLeavesBlock::new);
	public static final DeferredBlock<Block> DEKU_STAIRS = REGISTRY.register("deku_stairs", DekuStairsBlock::new);
	public static final DeferredBlock<Block> DEKU_SLAB = REGISTRY.register("deku_slab", DekuSlabBlock::new);
	public static final DeferredBlock<Block> DEKU_FENCE = REGISTRY.register("deku_fence", DekuFenceBlock::new);
	public static final DeferredBlock<Block> DEKU_FENCE_GATE = REGISTRY.register("deku_fence_gate", DekuFenceGateBlock::new);
	public static final DeferredBlock<Block> DEKU_PRESSURE_PLATE = REGISTRY.register("deku_pressure_plate", DekuPressurePlateBlock::new);
	public static final DeferredBlock<Block> DEKU_BUTTON = REGISTRY.register("deku_button", DekuButtonBlock::new);
	public static final DeferredBlock<Block> SHEIKAH_LIGHT = REGISTRY.register("sheikah_light", SheikahLightBlock::new);
	public static final DeferredBlock<Block> SHEIKAH_GRATE = REGISTRY.register("sheikah_grate", SheikahGrateBlock::new);
	public static final DeferredBlock<Block> SHEIKAH_GRATE_WALL = REGISTRY.register("sheikah_grate_wall", SheikahGrateWallBlock::new);
	public static final DeferredBlock<Block> SHEIKAH_PLATE = REGISTRY.register("sheikah_plate", SheikahPlateBlock::new);
	public static final DeferredBlock<Block> DESIGNED_SHEIKAH_PLATE = REGISTRY.register("designed_sheikah_plate", DesignedSheikahPlateBlock::new);
	public static final DeferredBlock<Block> CHISELED_SHEIKAH_PLATE = REGISTRY.register("chiseled_sheikah_plate", ChiseledSheikahPlateBlock::new);
	public static final DeferredBlock<Block> GLOWING_CHISELED_SHEIKAH_PLATE = REGISTRY.register("glowing_chiseled_sheikah_plate", GlowingChiseledSheikahPlateBlock::new);
	public static final DeferredBlock<Block> GLOWING_SHEIKAH_PLATE = REGISTRY.register("glowing_sheikah_plate", GlowingSheikahPlateBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
