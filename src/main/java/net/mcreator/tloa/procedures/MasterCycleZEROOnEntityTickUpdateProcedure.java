package net.mcreator.tloa.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.TloaMod;

public class MasterCycleZEROOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle() == false) {
			TloaMod.queueServerWork(600, () -> {
				if (entity.isVehicle() == false) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			});
		}
	}
}
