
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlos.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.Item;

import net.mcreator.tlos.item.TestingSwordItem;
import net.mcreator.tlos.item.SheikahSlateOnItem;
import net.mcreator.tlos.item.SheikahSlateItem;
import net.mcreator.tlos.TlosMod;

public class TlosModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TlosMod.MODID);
	public static final DeferredHolder<Item, Item> SHEIKAH_SLATE = REGISTRY.register("sheikah_slate", SheikahSlateItem::new);
	public static final DeferredHolder<Item, Item> SHEIKAH_SLATE_ON = REGISTRY.register("sheikah_slate_on", SheikahSlateOnItem::new);
	public static final DeferredHolder<Item, Item> TESTING_SWORD = REGISTRY.register("testing_sword", TestingSwordItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
