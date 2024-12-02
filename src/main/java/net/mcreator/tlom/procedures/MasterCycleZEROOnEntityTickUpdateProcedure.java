package net.mcreator.tlom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.tlom.TlomMod;

public class MasterCycleZEROOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle() == false) {
			TlomMod.queueServerWork(600, () -> {
				if (entity.isVehicle() == false) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			});
		}
	}
}
