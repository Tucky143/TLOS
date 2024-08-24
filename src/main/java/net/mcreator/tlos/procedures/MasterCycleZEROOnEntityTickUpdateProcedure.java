package net.mcreator.tlos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.tlos.TlosMod;

public class MasterCycleZEROOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle() == false) {
			TlosMod.queueServerWork(600, () -> {
				if (entity.isVehicle() == false) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			});
		}
	}
}
