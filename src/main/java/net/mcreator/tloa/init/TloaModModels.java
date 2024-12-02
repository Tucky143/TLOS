
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tloa.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.tloa.client.model.ModelSquareRemoteBomb;
import net.mcreator.tloa.client.model.ModelMasterCycle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TloaModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelSquareRemoteBomb.LAYER_LOCATION, ModelSquareRemoteBomb::createBodyLayer);
		event.registerLayerDefinition(ModelMasterCycle.LAYER_LOCATION, ModelMasterCycle::createBodyLayer);
	}
}
