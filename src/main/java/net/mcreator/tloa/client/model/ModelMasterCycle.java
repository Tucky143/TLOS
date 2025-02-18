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

// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelMasterCycle<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("tloa", "model_master_cycle"), "main");
	public final ModelPart body;
	public final ModelPart front_tire;
	public final ModelPart back_tire;

	public ModelMasterCycle(ModelPart root) {
		this.body = root.getChild("body");
		this.front_tire = root.getChild("front_tire");
		this.back_tire = root.getChild("back_tire");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(68, 38).addBox(-2.0F, 3.0F, -16.0F, 4.0F, 2.0F, 20.0F, new CubeDeformation(0.05F)).texOffs(0, 32).addBox(-2.0F, -2.0F, -18.0F, 4.0F, 5.0F, 24.0F, new CubeDeformation(0.05F)).texOffs(101, 12)
						.addBox(-2.0F, -3.0F, -19.0F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.05F)).texOffs(12, 72).addBox(-2.0F, -5.0F, -20.0F, 4.0F, 2.0F, 9.0F, new CubeDeformation(0.05F)).texOffs(0, 19)
						.addBox(-2.0F, -7.0F, -23.0F, 4.0F, 2.0F, 9.0F, new CubeDeformation(0.05F)).texOffs(0, 32).addBox(-2.0F, -5.0F, -25.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.05F)).texOffs(28, 15)
						.addBox(-2.0F, -2.0F, -28.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.05F)).texOffs(-1, 102).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.05F)),
				PartPose.offset(0.0F, 12.0F, 6.0F));
		PartDefinition front_tire = partdefinition.addOrReplaceChild("front_tire", CubeListBuilder.create().texOffs(48, 21).addBox(-1.0F, -4.0F, -3.9F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -10.0F));
		PartDefinition back_tire = partdefinition.addOrReplaceChild("back_tire", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 10.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		front_tire.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		back_tire.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
