
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tloa.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.tloa.TloaMod;

public class TloaModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, TloaMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> RUPEE_ADDED = REGISTRY.register("rupee_added", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("tloa", "rupee_added")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LIGHT_ARROW_SPLASH = REGISTRY.register("light_arrow_splash", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("tloa", "light_arrow_splash")));
}
