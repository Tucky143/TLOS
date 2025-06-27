package net.mcreator.tloa.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.TloaMod;

public class BombEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("ignited", true);
		TloaMod.queueServerWork(60, () -> {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 2, Level.ExplosionInteraction.MOB);
			if (!(entity == null)) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		});
	}
}
