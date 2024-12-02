package net.mcreator.tloa.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.tloa.init.TloaModEntities;

public class MasterCycleAbilityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = TloaModEntities.MASTER_CYCLE_ZERO.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.BUBBLE_COLUMN_UP, x, y, z, 5, 3, 3, 3, 1);
	}
}
