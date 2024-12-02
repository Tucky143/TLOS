
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlos.init;

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

import net.mcreator.tlos.procedures.SilverRupeePropertyValueProviderProcedure;
import net.mcreator.tlos.procedures.RedRupeePropertyValueProviderProcedure;
import net.mcreator.tlos.procedures.PurpleRupeePropertyValueProviderProcedure;
import net.mcreator.tlos.procedures.GreenRupeePropertyValueProviderProcedure;
import net.mcreator.tlos.procedures.GoldRupeePropertyValueProviderProcedure;
import net.mcreator.tlos.procedures.BlueRupeePropertyValueProviderProcedure;
import net.mcreator.tlos.item.SilverRupeeItem;
import net.mcreator.tlos.item.SheikahSlateOnItem;
import net.mcreator.tlos.item.SheikahSlateItem;
import net.mcreator.tlos.item.RedRupeeItem;
import net.mcreator.tlos.item.PurpleRupeeItem;
import net.mcreator.tlos.item.MasterSwordPoweredItem;
import net.mcreator.tlos.item.MasterSwordItem;
import net.mcreator.tlos.item.GreenRupeeItem;
import net.mcreator.tlos.item.GoldRupeeItem;
import net.mcreator.tlos.item.BlueRupeeItem;
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
				ItemProperties.register(GREEN_RUPEE.get(), ResourceLocation.parse("tlos:green_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) GreenRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(BLUE_RUPEE.get(), ResourceLocation.parse("tlos:blue_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) BlueRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(RED_RUPEE.get(), ResourceLocation.parse("tlos:red_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) RedRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(PURPLE_RUPEE.get(), ResourceLocation.parse("tlos:purple_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) PurpleRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(SILVER_RUPEE.get(), ResourceLocation.parse("tlos:silver_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) SilverRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(GOLD_RUPEE.get(), ResourceLocation.parse("tlos:gold_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) GoldRupeePropertyValueProviderProcedure.execute());
			});
		}
	}
}
