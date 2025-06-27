
package net.mcreator.tloa.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.tloa.entity.BombEntity;
import net.mcreator.tloa.client.model.animations.BombAnimation;
import net.mcreator.tloa.client.model.ModelBomb;

import com.mojang.blaze3d.vertex.PoseStack;

public class BombRenderer extends MobRenderer<BombEntity, ModelBomb<BombEntity>> {
	public BombRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelBomb.LAYER_LOCATION)), 0.8f);
	}

	@Override
	protected void scale(BombEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.75f, 0.75f, 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(BombEntity entity) {
		return ResourceLocation.parse("tloa:textures/entities/bomb.png");
	}

	private static final class AnimatedModel extends ModelBomb<BombEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<BombEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(BombEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, BombAnimation.ignited, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(BombEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
