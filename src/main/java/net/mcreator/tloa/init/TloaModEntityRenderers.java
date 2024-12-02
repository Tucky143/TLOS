
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tloa.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.tloa.client.renderer.SquareRemoteBombRenderer;
import net.mcreator.tloa.client.renderer.MasterCycleZERORenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TloaModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TloaModEntities.MASTER_CYCLE_ZERO.get(), MasterCycleZERORenderer::new);
		event.registerEntityRenderer(TloaModEntities.SQUARE_REMOTE_BOMB.get(), SquareRemoteBombRenderer::new);
	}
}
