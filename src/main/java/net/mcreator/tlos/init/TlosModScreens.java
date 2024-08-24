
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlos.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.tlos.client.gui.SheikahSlateGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TlosModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(TlosModMenus.SHEIKAH_SLATE_GUI.get(), SheikahSlateGUIScreen::new);
	}
}
