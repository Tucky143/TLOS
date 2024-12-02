
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tloa.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.tloa.entity.SquareRemoteBombEntity;
import net.mcreator.tloa.entity.MasterCycleZEROEntity;
import net.mcreator.tloa.TloaMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TloaModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, TloaMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<MasterCycleZEROEntity>> MASTER_CYCLE_ZERO = register("master_cycle_zero",
			EntityType.Builder.<MasterCycleZEROEntity>of(MasterCycleZEROEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune().sized(0.6f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<SquareRemoteBombEntity>> SQUARE_REMOTE_BOMB = register("square_remote_bomb",
			EntityType.Builder.<SquareRemoteBombEntity>of(SquareRemoteBombEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3)

					.sized(0.6f, 0.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		MasterCycleZEROEntity.init(event);
		SquareRemoteBombEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MASTER_CYCLE_ZERO.get(), MasterCycleZEROEntity.createAttributes().build());
		event.put(SQUARE_REMOTE_BOMB.get(), SquareRemoteBombEntity.createAttributes().build());
	}
}
