
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlom.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.tlom.client.renderer.SquareRemoteBombRenderer;
import net.mcreator.tlom.client.renderer.MasterCycleZERORenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TlomModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TlomModEntities.MASTER_CYCLE_ZERO.get(), MasterCycleZERORenderer::new);
		event.registerEntityRenderer(TlomModEntities.SQUARE_REMOTE_BOMB.get(), SquareRemoteBombRenderer::new);
	}
}
