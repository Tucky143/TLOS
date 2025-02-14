
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tloa.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.tloa.network.UseRuneMessage;
import net.mcreator.tloa.network.OpenSheikahSlateGUIMessage;
import net.mcreator.tloa.network.ClimbingKeyMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TloaModKeyMappings {
	public static final KeyMapping OPEN_SHEIKAH_SLATE_GUI = new KeyMapping("key.tloa.open_sheikah_slate_gui", GLFW.GLFW_KEY_R, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenSheikahSlateGUIMessage(0, 0));
				OpenSheikahSlateGUIMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_RUNE = new KeyMapping("key.tloa.use_rune", GLFW.GLFW_KEY_X, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new UseRuneMessage(0, 0));
				UseRuneMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CLIMBING_KEY = new KeyMapping("key.tloa.climbing_key", GLFW.GLFW_KEY_Q, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ClimbingKeyMessage(0, 0));
				ClimbingKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				CLIMBING_KEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - CLIMBING_KEY_LASTPRESS);
				PacketDistributor.sendToServer(new ClimbingKeyMessage(1, dt));
				ClimbingKeyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long CLIMBING_KEY_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OPEN_SHEIKAH_SLATE_GUI);
		event.register(USE_RUNE);
		event.register(CLIMBING_KEY);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				OPEN_SHEIKAH_SLATE_GUI.consumeClick();
				USE_RUNE.consumeClick();
				CLIMBING_KEY.consumeClick();
			}
		}
	}
}
