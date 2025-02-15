
package net.mcreator.tloa.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tloa.entity.MasterCycleZEROEntity;
import net.mcreator.tloa.client.model.ModelMasterCycle;

import com.mojang.blaze3d.vertex.PoseStack;

public class MasterCycleZERORenderer extends MobRenderer<MasterCycleZEROEntity, ModelMasterCycle<MasterCycleZEROEntity>> {
	public MasterCycleZERORenderer(EntityRendererProvider.Context context) {
		super(context, new ModelMasterCycle<MasterCycleZEROEntity>(context.bakeLayer(ModelMasterCycle.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(MasterCycleZEROEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.4f, 1.4f, 1.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(MasterCycleZEROEntity entity) {
		return ResourceLocation.parse("tloa:textures/entities/master_cycle.png");
	}
}
