package net.mcreator.tloa.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelBomb<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("tloa", "model_bomb"), "main");
	public final ModelPart fuse;
	public final ModelPart bone;

	public ModelBomb(ModelPart root) {
		this.fuse = root.getChild("fuse");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition fuse = partdefinition.addOrReplaceChild("fuse",
				CubeListBuilder.create().texOffs(24, 32).addBox(-1.0F, -5.5F, -0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 32).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.5F, 0.5F));
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -7.5F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 32).addBox(-2.0F, -8.5F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 15.5F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		fuse.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
