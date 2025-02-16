
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tloa.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.tloa.potion.ShockedMobEffect;
import net.mcreator.tloa.potion.FrozenMobEffect;
import net.mcreator.tloa.TloaMod;

public class TloaModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, TloaMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> SHOCKED = REGISTRY.register("shocked", () -> new ShockedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FROZEN = REGISTRY.register("frozen", () -> new FrozenMobEffect());
}
