
package net.mcreator.tlom.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tlom.entity.SquareRemoteBombEntity;
import net.mcreator.tlom.client.model.ModelSquareRemoteBomb;

public class SquareRemoteBombRenderer extends MobRenderer<SquareRemoteBombEntity, ModelSquareRemoteBomb<SquareRemoteBombEntity>> {
	public SquareRemoteBombRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSquareRemoteBomb<SquareRemoteBombEntity>(context.bakeLayer(ModelSquareRemoteBomb.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(SquareRemoteBombEntity entity) {
		return ResourceLocation.parse("tlom:textures/entities/square_remote_bomb.png");
	}
}
