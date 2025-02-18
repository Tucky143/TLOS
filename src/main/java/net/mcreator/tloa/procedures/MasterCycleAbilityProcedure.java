package net.mcreator.tloa.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.tloa.init.TloaModEntities;
import net.mcreator.tloa.entity.MasterCycleZEROEntity;

import java.util.Comparator;

public class MasterCycleAbilityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean variable = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof MasterCycleZEROEntity) {
					if (!entityiterator.level().isClientSide())
						entityiterator.discard();
					variable = true;
				}
			}
		}
		if (variable == false) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TloaModEntities.MASTER_CYCLE_ZERO.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SPLASH, x, y, z, 15, 1, 1, 1, 0.1);
		}
	}
}
