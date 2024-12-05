
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tloa.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.tloa.procedures.SilverRupeePropertyValueProviderProcedure;
import net.mcreator.tloa.procedures.RedRupeePropertyValueProviderProcedure;
import net.mcreator.tloa.procedures.PurpleRupeePropertyValueProviderProcedure;
import net.mcreator.tloa.procedures.GreenRupeePropertyValueProviderProcedure;
import net.mcreator.tloa.procedures.GoldRupeePropertyValueProviderProcedure;
import net.mcreator.tloa.procedures.BlueRupeePropertyValueProviderProcedure;
import net.mcreator.tloa.item.SilverRupeeItem;
import net.mcreator.tloa.item.SheikahSlateOnItem;
import net.mcreator.tloa.item.SheikahSlateItem;
import net.mcreator.tloa.item.RedRupeeItem;
import net.mcreator.tloa.item.PurpleRupeeItem;
import net.mcreator.tloa.item.MasterSwordPoweredItem;
import net.mcreator.tloa.item.MasterSwordItem;
import net.mcreator.tloa.item.LightBowItem;
import net.mcreator.tloa.item.LightArrowItemItem;
import net.mcreator.tloa.item.KokiriSwordItem;
import net.mcreator.tloa.item.HylianShieldItem;
import net.mcreator.tloa.item.GreenRupeeItem;
import net.mcreator.tloa.item.GoldRupeeItem;
import net.mcreator.tloa.item.DekuShieldItem;
import net.mcreator.tloa.item.BlueRupeeItem;
import net.mcreator.tloa.TloaMod;

public class TloaModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TloaMod.MODID);
	public static final DeferredItem<Item> SHEIKAH_SLATE = REGISTRY.register("sheikah_slate", SheikahSlateItem::new);
	public static final DeferredItem<Item> SHEIKAH_SLATE_ON = REGISTRY.register("sheikah_slate_on", SheikahSlateOnItem::new);
	public static final DeferredItem<Item> MASTER_SWORD = REGISTRY.register("master_sword", MasterSwordItem::new);
	public static final DeferredItem<Item> MASTER_SWORD_POWERED = REGISTRY.register("master_sword_powered", MasterSwordPoweredItem::new);
	public static final DeferredItem<Item> LOST_WOOD = block(TloaModBlocks.LOST_WOOD);
	public static final DeferredItem<Item> LOST_LOG = block(TloaModBlocks.LOST_LOG);
	public static final DeferredItem<Item> LOST_PLANKS = block(TloaModBlocks.LOST_PLANKS);
	public static final DeferredItem<Item> LOST_STAIRS = block(TloaModBlocks.LOST_STAIRS);
	public static final DeferredItem<Item> LOST_SLAB = block(TloaModBlocks.LOST_SLAB);
	public static final DeferredItem<Item> LOST_FENCE = block(TloaModBlocks.LOST_FENCE);
	public static final DeferredItem<Item> LOST_FENCE_GATE = block(TloaModBlocks.LOST_FENCE_GATE);
	public static final DeferredItem<Item> LOST_PRESSURE_PLATE = block(TloaModBlocks.LOST_PRESSURE_PLATE);
	public static final DeferredItem<Item> LOST_BUTTON = block(TloaModBlocks.LOST_BUTTON);
	public static final DeferredItem<Item> GREEN_RUPEE = REGISTRY.register("green_rupee", GreenRupeeItem::new);
	public static final DeferredItem<Item> BLUE_RUPEE = REGISTRY.register("blue_rupee", BlueRupeeItem::new);
	public static final DeferredItem<Item> RED_RUPEE = REGISTRY.register("red_rupee", RedRupeeItem::new);
	public static final DeferredItem<Item> PURPLE_RUPEE = REGISTRY.register("purple_rupee", PurpleRupeeItem::new);
	public static final DeferredItem<Item> SILVER_RUPEE = REGISTRY.register("silver_rupee", SilverRupeeItem::new);
	public static final DeferredItem<Item> GOLD_RUPEE = REGISTRY.register("gold_rupee", GoldRupeeItem::new);
	public static final DeferredItem<Item> DEKU_WOOD = block(TloaModBlocks.DEKU_WOOD);
	public static final DeferredItem<Item> DEKU_LOG = block(TloaModBlocks.DEKU_LOG);
	public static final DeferredItem<Item> DEKU_PLANKS = block(TloaModBlocks.DEKU_PLANKS);
	public static final DeferredItem<Item> DEKU_LEAVES = block(TloaModBlocks.DEKU_LEAVES);
	public static final DeferredItem<Item> DEKU_STAIRS = block(TloaModBlocks.DEKU_STAIRS);
	public static final DeferredItem<Item> DEKU_SLAB = block(TloaModBlocks.DEKU_SLAB);
	public static final DeferredItem<Item> DEKU_FENCE = block(TloaModBlocks.DEKU_FENCE);
	public static final DeferredItem<Item> DEKU_FENCE_GATE = block(TloaModBlocks.DEKU_FENCE_GATE);
	public static final DeferredItem<Item> DEKU_PRESSURE_PLATE = block(TloaModBlocks.DEKU_PRESSURE_PLATE);
	public static final DeferredItem<Item> DEKU_BUTTON = block(TloaModBlocks.DEKU_BUTTON);
	public static final DeferredItem<Item> LIGHT_BOW = REGISTRY.register("light_bow", LightBowItem::new);
	public static final DeferredItem<Item> LIGHT_ARROW_ITEM = REGISTRY.register("light_arrow_item", LightArrowItemItem::new);
	public static final DeferredItem<Item> DEKU_SHIELD = REGISTRY.register("deku_shield", DekuShieldItem::new);
	public static final DeferredItem<Item> HYLIAN_SHIELD = REGISTRY.register("hylian_shield", HylianShieldItem::new);
	public static final DeferredItem<Item> KOKIRI_SWORD = REGISTRY.register("kokiri_sword", KokiriSwordItem::new);

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
				ItemProperties.register(GREEN_RUPEE.get(), ResourceLocation.parse("tloa:green_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) GreenRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(BLUE_RUPEE.get(), ResourceLocation.parse("tloa:blue_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) BlueRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(RED_RUPEE.get(), ResourceLocation.parse("tloa:red_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) RedRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(PURPLE_RUPEE.get(), ResourceLocation.parse("tloa:purple_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) PurpleRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(SILVER_RUPEE.get(), ResourceLocation.parse("tloa:silver_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) SilverRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(GOLD_RUPEE.get(), ResourceLocation.parse("tloa:gold_rupee_value"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) GoldRupeePropertyValueProviderProcedure.execute());
				ItemProperties.register(DEKU_SHIELD.get(), ResourceLocation.parse("minecraft:blocking"), ItemProperties.getProperty(new ItemStack(Items.SHIELD), ResourceLocation.parse("minecraft:blocking")));
				ItemProperties.register(HYLIAN_SHIELD.get(), ResourceLocation.parse("minecraft:blocking"), ItemProperties.getProperty(new ItemStack(Items.SHIELD), ResourceLocation.parse("minecraft:blocking")));
			});
		}
	}
}
