
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlos.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.tlos.item.SheikahSlateOnItem;
import net.mcreator.tlos.item.SheikahSlateItem;
import net.mcreator.tlos.item.MasterSwordPoweredItem;
import net.mcreator.tlos.item.MasterSwordItem;
import net.mcreator.tlos.TlosMod;

public class TlosModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TlosMod.MODID);
	public static final DeferredItem<Item> SHEIKAH_SLATE = REGISTRY.register("sheikah_slate", SheikahSlateItem::new);
	public static final DeferredItem<Item> SHEIKAH_SLATE_ON = REGISTRY.register("sheikah_slate_on", SheikahSlateOnItem::new);
	public static final DeferredItem<Item> MASTER_SWORD = REGISTRY.register("master_sword", MasterSwordItem::new);
	public static final DeferredItem<Item> MASTER_SWORD_POWERED = REGISTRY.register("master_sword_powered", MasterSwordPoweredItem::new);
	public static final DeferredItem<Item> LOST_WOOD = block(TlosModBlocks.LOST_WOOD);
	public static final DeferredItem<Item> LOST_LOG = block(TlosModBlocks.LOST_LOG);
	public static final DeferredItem<Item> LOST_PLANKS = block(TlosModBlocks.LOST_PLANKS);
	public static final DeferredItem<Item> LOST_STAIRS = block(TlosModBlocks.LOST_STAIRS);
	public static final DeferredItem<Item> LOST_SLAB = block(TlosModBlocks.LOST_SLAB);
	public static final DeferredItem<Item> LOST_FENCE = block(TlosModBlocks.LOST_FENCE);
	public static final DeferredItem<Item> LOST_FENCE_GATE = block(TlosModBlocks.LOST_FENCE_GATE);
	public static final DeferredItem<Item> LOST_PRESSURE_PLATE = block(TlosModBlocks.LOST_PRESSURE_PLATE);
	public static final DeferredItem<Item> LOST_BUTTON = block(TlosModBlocks.LOST_BUTTON);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
