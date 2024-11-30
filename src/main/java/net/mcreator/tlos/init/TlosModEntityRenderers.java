
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlos.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.tlos.client.renderer.SquareRemoteBombRenderer;
import net.mcreator.tlos.client.renderer.MasterCycleZERORenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TlosModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TlosModEntities.MASTER_CYCLE_ZERO.get(), MasterCycleZERORenderer::new);
		event.registerEntityRenderer(TlosModEntities.SQUARE_REMOTE_BOMB.get(), SquareRemoteBombRenderer::new);
	}
}
