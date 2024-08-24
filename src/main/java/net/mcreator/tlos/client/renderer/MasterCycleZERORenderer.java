
package net.mcreator.tlos.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.tlos.entity.MasterCycleZEROEntity;
import net.mcreator.tlos.client.model.ModelMasterCycle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MasterCycleZERORenderer extends MobRenderer<MasterCycleZEROEntity, ModelMasterCycle<MasterCycleZEROEntity>> {
	public MasterCycleZERORenderer(EntityRendererProvider.Context context) {
		super(context, new ModelMasterCycle(context.bakeLayer(ModelMasterCycle.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<MasterCycleZEROEntity, ModelMasterCycle<MasterCycleZEROEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("tlos:textures/entities/master_cycle.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MasterCycleZEROEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new ModelMasterCycle(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMasterCycle.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	protected void scale(MasterCycleZEROEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.4f, 1.4f, 1.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(MasterCycleZEROEntity entity) {
		return new ResourceLocation("tlos:textures/entities/master_cycle.png");
	}
}
