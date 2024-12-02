
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.tlom.procedures.SilverRupeePropertyValueProviderProcedure;
import net.mcreator.tlom.procedures.RedRupeePropertyValueProviderProcedure;
import net.mcreator.tlom.procedures.PurpleRupeePropertyValueProviderProcedure;
import net.mcreator.tlom.procedures.GreenRupeePropertyValueProviderProcedure;
import net.mcreator.tlom.procedures.GoldRupeePropertyValueProviderProcedure;
import net.mcreator.tlom.procedures.BlueRupeePropertyValueProviderProcedure;
import net.mcreator.tlom.item.SilverRupeeItem;
import net.mcreator.tlom.item.SheikahSlateOnItem;
import net.mcreator.tlom.item.SheikahSlateItem;
import net.mcreator.tlom.item.RedRupeeItem;
import net.mcreator.tlom.item.PurpleRupeeItem;
import net.mcreator.tlom.item.MasterSwordPoweredItem;
import net.mcreator.tlom.item.MasterSwordItem;
import net.mcreator.tlom.item.GreenRupeeItem;
import net.mcreator.tlom.item.GoldRupeeItem;
import net.mcreator.tlom.item.BlueRupeeItem;
import net.mcreator.tlom.TlomMod;

public class TlomModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TlomMod.MODID);
	public static final DeferredItem<Item> SHEIKAH_SLATE = REGISTRY.register("sheikah_slate", SheikahSlateItem::new);
	public static final DeferredItem<Item> SHEIKAH_SLATE_ON = REGISTRY.register("sheikah_slate_on", SheikahSlateOnItem::new);
	public static final DeferredItem<Item> MASTER_SWORD = REGISTRY.register("master_sword", MasterSwordItem::new);
	public static final DeferredItem<Item> MASTER_SWORD_POWERED = REGISTRY.register("master_sword_powered", MasterSwordPoweredItem::new);
	public static final DeferredItem<Item> LOST_WOOD = block(TlomModBlocks.LOST_WOOD);
	public static final DeferredItem<Item> LOST_LOG = block(TlomModBlocks.LOST_LOG);
	public static final DeferredItem<Item> LOST_PLANKS = block(TlomModBlocks.LOST_PLANKS);
	public static final DeferredItem<Item> LOST_STAIRS = block(TlomModBlocks.LOST_STAIRS);
	public static final DeferredItem<Item> LOST_SLAB = block(TlomModBlocks.LOST_SLAB);
	public static final DeferredItem<Item> LOST_FENCE = block(TlomModBlocks.LOST_FENCE);
	public static final DeferredItem<Item> LOST_FENCE_GATE = block(TlomModBlocks.LOST_FENCE_GATE);
	public static final DeferredItem<Item> LOST_PRESSURE_PLATE = block(TlomModBlocks.LOST_PRESSURE_PLATE);
	public static final DeferredItem<Item> LOST_BUTTON = block(TlomModBlocks.LOST_BUTTON);
	public static final DeferredItem<Item> GREEN_RUPEE = REGISTRY.register("green_rupee", GreenRupeeItem::new);
	public static final DeferredItem<Item> BLUE_RUPEE = REGISTRY.register("blue_rupee", BlueRupeeItem::new);
	public static final DeferredItem<Item> RED_RUPEE = REGISTRY.register("red_rupee", RedRupeeItem::new);
	public static final DeferredItem<Item> PURPLE_RUPEE = REGISTRY.register("purple_rupee", PurpleRupeeItem::new);
	public static final DeferredItem<Item> SILVER_RUPEE = REGISTRY.register("silver_rupee", SilverRupeeItem::new);
	public static final DeferredItem<Item> GOLD_RUPEE = REGISTRY.register("gold_rupee", GoldRupeeItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void clientLoad(FMLClientSetupEvent event) {
			event.enqueueWork(() -> {
				ItemProperties.register(GREEN_RUPEE.get(), ResourceLocation.parse("tlom:green_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) GreenRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(BLUE_RUPEE.get(), ResourceLocation.parse("tlom:blue_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) BlueRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(RED_RUPEE.get(), ResourceLocation.parse("tlom:red_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) RedRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(PURPLE_RUPEE.get(), ResourceLocation.parse("tlom:purple_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) PurpleRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(SILVER_RUPEE.get(), ResourceLocation.parse("tlom:silver_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) SilverRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(GOLD_RUPEE.get(), ResourceLocation.parse("tlom:gold_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) GoldRupeePropertyValueProviderProcedure.execute());
			});
		}
	}
}
