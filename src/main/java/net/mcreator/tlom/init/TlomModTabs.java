
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlom.init;

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

import net.mcreator.tlom.TlomMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TlomModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TlomMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TLOM_ITEMS = REGISTRY.register("tlom_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tlom.tlom_items")).icon(() -> new ItemStack(TlomModItems.SHEIKAH_SLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TlomModItems.SHEIKAH_SLATE.get());
				tabData.accept(TlomModItems.MASTER_SWORD.get());
				tabData.accept(TlomModItems.MASTER_SWORD_POWERED.get());
				tabData.accept(TlomModItems.GREEN_RUPEE.get());
				tabData.accept(TlomModItems.BLUE_RUPEE.get());
				tabData.accept(TlomModItems.RED_RUPEE.get());
				tabData.accept(TlomModItems.PURPLE_RUPEE.get());
				tabData.accept(TlomModItems.SILVER_RUPEE.get());
				tabData.accept(TlomModItems.GOLD_RUPEE.get());
			}).withSearchBar().build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TLOM_BLOCKS = REGISTRY.register("tlom_blocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tlom.tlom_blocks")).icon(() -> new ItemStack(TlomModBlocks.LOST_LOG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TlomModBlocks.LOST_WOOD.get().asItem());
				tabData.accept(TlomModBlocks.LOST_LOG.get().asItem());
				tabData.accept(TlomModBlocks.LOST_PLANKS.get().asItem());
				tabData.accept(TlomModBlocks.LOST_STAIRS.get().asItem());
				tabData.accept(TlomModBlocks.LOST_SLAB.get().asItem());
				tabData.accept(TlomModBlocks.LOST_FENCE.get().asItem());
				tabData.accept(TlomModBlocks.LOST_FENCE_GATE.get().asItem());
				tabData.accept(TlomModBlocks.LOST_PRESSURE_PLATE.get().asItem());
				tabData.accept(TlomModBlocks.LOST_BUTTON.get().asItem());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(TlomModItems.SHEIKAH_SLATE.get());
		}
	}
}
