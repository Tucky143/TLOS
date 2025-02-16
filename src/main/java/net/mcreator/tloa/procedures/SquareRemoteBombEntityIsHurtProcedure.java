package net.mcreator.tloa.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.tloa.entity.SquareRemoteBombEntity;
import net.mcreator.tloa.TloaMod;

public class SquareRemoteBombEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		if (damagesource.is(DamageTypes.FALL)) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(1);
		} else {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 1, Level.ExplosionInteraction.NONE);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.GLOW_SQUID_INK, x, y, z, 25, 1, 2, 1, 0.5);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
			TloaMod.queueServerWork(20, () -> {
				if (entity instanceof SquareRemoteBombEntity) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(0);
				}
			});
		}
	}
}
