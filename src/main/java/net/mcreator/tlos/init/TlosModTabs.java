
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlos.init;

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

import net.mcreator.tlos.TlosMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TlosModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TlosMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TLOS_ITEMS = REGISTRY.register("tlos_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tlos.tlos_items")).icon(() -> new ItemStack(TlosModItems.SHEIKAH_SLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TlosModItems.SHEIKAH_SLATE.get());
				tabData.accept(TlosModItems.MASTER_SWORD.get());
				tabData.accept(TlosModItems.MASTER_SWORD_POWERED.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(TlosModItems.SHEIKAH_SLATE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(TlosModBlocks.LOST_WOOD.get().asItem());
			tabData.accept(TlosModBlocks.LOST_LOG.get().asItem());
			tabData.accept(TlosModBlocks.LOST_PLANKS.get().asItem());
			tabData.accept(TlosModBlocks.LOST_STAIRS.get().asItem());
			tabData.accept(TlosModBlocks.LOST_SLAB.get().asItem());
			tabData.accept(TlosModBlocks.LOST_FENCE.get().asItem());
			tabData.accept(TlosModBlocks.LOST_FENCE_GATE.get().asItem());
			tabData.accept(TlosModBlocks.LOST_PRESSURE_PLATE.get().asItem());
			tabData.accept(TlosModBlocks.LOST_BUTTON.get().asItem());
		}
	}
}
