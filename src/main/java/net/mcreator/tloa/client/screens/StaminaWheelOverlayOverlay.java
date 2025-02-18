
package net.mcreator.tloa.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.tloa.procedures.StaminaWheelOverlayDrainProcedure;
import net.mcreator.tloa.procedures.StaminaWheelOverlayDisplayOverlayIngameProcedure;

@EventBusSubscriber({Dist.CLIENT})
public class StaminaWheelOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (StaminaWheelOverlayDisplayOverlayIngameProcedure.execute(entity)) {

			event.getGuiGraphics().blit(ResourceLocation.parse("tloa:textures/screens/stamina_wheel.png"), w / 2 + -39, h / 2 + 8, 0, Mth.clamp((int) StaminaWheelOverlayDrainProcedure.execute(entity) * 32, 0, 448), 32, 32, 32, 480);

		}
	}
}
