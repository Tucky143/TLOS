
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tlos.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.tlos.entity.MasterCycleZEROEntity;
import net.mcreator.tlos.TlosMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TlosModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, TlosMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<MasterCycleZEROEntity>> MASTER_CYCLE_ZERO = register("master_cycle_zero",
			EntityType.Builder.<MasterCycleZEROEntity>of(MasterCycleZEROEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune().sized(0.6f, 0.9f));

	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(SpawnPlacementRegisterEvent event) {
		MasterCycleZEROEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MASTER_CYCLE_ZERO.get(), MasterCycleZEROEntity.createAttributes().build());
	}
}
