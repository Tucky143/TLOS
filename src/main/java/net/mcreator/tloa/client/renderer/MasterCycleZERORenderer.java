
package net.mcreator.tloa.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.tloa.entity.MasterCycleZEROEntity;
import net.mcreator.tloa.client.model.animations.MasterCycleAnimation;
import net.mcreator.tloa.client.model.ModelMasterCycle;

import com.mojang.blaze3d.vertex.PoseStack;

public class MasterCycleZERORenderer extends MobRenderer<MasterCycleZEROEntity, ModelMasterCycle<MasterCycleZEROEntity>> {
	public MasterCycleZERORenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelMasterCycle.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(MasterCycleZEROEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.4f, 1.4f, 1.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(MasterCycleZEROEntity entity) {
		return ResourceLocation.parse("tloa:textures/entities/master_cycle.png");
	}

	private static final class AnimatedModel extends ModelMasterCycle<MasterCycleZEROEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<MasterCycleZEROEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(MasterCycleZEROEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animateWalk(MasterCycleAnimation.MasterCycleWheels, limbSwing, limbSwingAmount, 1f, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(MasterCycleZEROEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
