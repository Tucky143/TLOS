
package net.mcreator.tloa.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tloa.entity.SquareRemoteBombEntity;
import net.mcreator.tloa.client.model.ModelSquareRemoteBomb;

import com.mojang.blaze3d.vertex.PoseStack;

public class SquareRemoteBombRenderer extends MobRenderer<SquareRemoteBombEntity, ModelSquareRemoteBomb<SquareRemoteBombEntity>> {
	public SquareRemoteBombRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSquareRemoteBomb<SquareRemoteBombEntity>(context.bakeLayer(ModelSquareRemoteBomb.LAYER_LOCATION)), 0.1f);
	}

	@Override
	protected void scale(SquareRemoteBombEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.9f, 0.9f, 0.9f);
	}

	@Override
	public ResourceLocation getTextureLocation(SquareRemoteBombEntity entity) {
		return ResourceLocation.parse("tloa:textures/entities/square_remote_bomb.png");
	}
}
