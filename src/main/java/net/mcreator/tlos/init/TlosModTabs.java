
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
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(TlosModItems.SHEIKAH_SLATE.get());
		}
	}
}
