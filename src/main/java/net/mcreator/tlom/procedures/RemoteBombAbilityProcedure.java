package net.mcreator.tlom.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.tlom.init.TlomModEntities;
import net.mcreator.tlom.entity.SquareRemoteBombEntity;

public class RemoteBombAbilityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(SquareRemoteBombEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @e[type=tlos:square_remote_bomb]");
				}
			}
		} else {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TlomModEntities.SQUARE_REMOTE_BOMB.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement((entity.getDeltaMovement().x()), (entity.getLookAngle().y), (entity.getLookAngle().z));
				}
			}
		}
	}
}
