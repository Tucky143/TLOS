
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.tlom.TlomMod;

public class TlomModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, TlomMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> MASTER_CYCLE_CRUSHES = REGISTRY.register("master_cycle_crushes", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("tlom", "master_cycle_crushes")));
}
