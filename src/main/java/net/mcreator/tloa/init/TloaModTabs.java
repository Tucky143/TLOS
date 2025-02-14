
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tloa.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.tloa.TloaMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TloaModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TloaMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TLOA_ITEMS = REGISTRY.register("tloa_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tloa.tloa_items")).icon(() -> new ItemStack(TloaModItems.GREEN_RUPEE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TloaModItems.PARAGLIDER.get());
				tabData.accept(TloaModItems.MASTER_SWORD_POWERED.get());
				tabData.accept(TloaModItems.MASTER_SWORD.get());
				tabData.accept(TloaModItems.KOKIRI_SWORD.get());
				tabData.accept(TloaModItems.FLAMEBLADE.get());
				tabData.accept(TloaModItems.GREAT_FLAMEBLADE.get());
				tabData.accept(TloaModItems.FROSTBLADE.get());
				tabData.accept(TloaModItems.GREAT_FROSTBLADE.get());
				tabData.accept(TloaModItems.HYLIAN_SHIELD.get());
				tabData.accept(TloaModItems.DEKU_SHIELD.get());
				tabData.accept(TloaModItems.LIGHT_BOW.get());
				tabData.accept(TloaModItems.GREEN_RUPEE.get());
				tabData.accept(TloaModItems.BLUE_RUPEE.get());
				tabData.accept(TloaModItems.RED_RUPEE.get());
				tabData.accept(TloaModItems.PURPLE_RUPEE.get());
				tabData.accept(TloaModItems.SILVER_RUPEE.get());
				tabData.accept(TloaModItems.GOLD_RUPEE.get());
				tabData.accept(TloaModItems.SHEIKAH_SLATE.get());
			}).withSearchBar().build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TLOA_BLOCKS_TAB = REGISTRY.register("tloa_blocks_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tloa.tloa_blocks_tab")).icon(() -> new ItemStack(TloaModBlocks.GLOWING_CHISELED_SHEIKAH_PLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TloaModBlocks.LOST_WOOD.get().asItem());
				tabData.accept(TloaModBlocks.LOST_LOG.get().asItem());
				tabData.accept(TloaModBlocks.LOST_PLANKS.get().asItem());
				tabData.accept(TloaModBlocks.LOST_STAIRS.get().asItem());
				tabData.accept(TloaModBlocks.LOST_SLAB.get().asItem());
				tabData.accept(TloaModBlocks.LOST_FENCE.get().asItem());
				tabData.accept(TloaModBlocks.LOST_FENCE_GATE.get().asItem());
				tabData.accept(TloaModBlocks.LOST_PRESSURE_PLATE.get().asItem());
				tabData.accept(TloaModBlocks.LOST_BUTTON.get().asItem());
				tabData.accept(TloaModBlocks.DEKU_WOOD.get().asItem());
				tabData.accept(TloaModBlocks.DEKU_LOG.get().asItem());
				tabData.accept(TloaModBlocks.DEKU_PLANKS.get().asItem());
				tabData.accept(TloaModBlocks.DEKU_LEAVES.get().asItem());
				tabData.accept(TloaModBlocks.DEKU_STAIRS.get().asItem());
				tabData.accept(TloaModBlocks.DEKU_SLAB.get().asItem());
				tabData.accept(TloaModBlocks.DEKU_FENCE.get().asItem());
				tabData.accept(TloaModBlocks.DEKU_FENCE_GATE.get().asItem());
				tabData.accept(TloaModBlocks.DEKU_PRESSURE_PLATE.get().asItem());
				tabData.accept(TloaModBlocks.DEKU_BUTTON.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_LIGHT.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_GRATE.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_GRATE_WALL.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_PLATE.get().asItem());
				tabData.accept(TloaModBlocks.CHISELED_SHEIKAH_PLATE.get().asItem());
				tabData.accept(TloaModBlocks.GLOWING_CHISELED_SHEIKAH_PLATE.get().asItem());
				tabData.accept(TloaModBlocks.GLOWING_SHEIKAH_PLATE.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_PLATE_SLAB.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_PLATE_STAIR.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_PLATE_WALL.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_STONE.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_STONE_SLAB.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_STONE_STAIR.get().asItem());
				tabData.accept(TloaModBlocks.SHEIKAH_STONE_WALL.get().asItem());
			}).withSearchBar().withTabsBefore(TLOA_ITEMS.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(TloaModItems.SHEIKAH_SLATE.get());
		}
	}
}
