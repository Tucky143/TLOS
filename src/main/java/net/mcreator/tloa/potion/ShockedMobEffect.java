
package net.mcreator.tloa.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.tloa.TloaMod;

public class ShockedMobEffect extends MobEffect {
	public ShockedMobEffect() {
		super(MobEffectCategory.HARMFUL, -205, ParticleTypes.END_ROD);
		this.addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath(TloaMod.MODID, "effect.shocked_0"), -50, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(TloaMod.MODID, "effect.shocked_1"), -50, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(TloaMod.MODID, "effect.shocked_2"), -50, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}
