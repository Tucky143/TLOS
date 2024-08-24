
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlos.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.tlos.world.inventory.SheikahSlateGUIMenu;
import net.mcreator.tlos.TlosMod;

public class TlosModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, TlosMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<SheikahSlateGUIMenu>> SHEIKAH_SLATE_GUI = REGISTRY.register("sheikah_slate_gui", () -> IMenuTypeExtension.create(SheikahSlateGUIMenu::new));
}
