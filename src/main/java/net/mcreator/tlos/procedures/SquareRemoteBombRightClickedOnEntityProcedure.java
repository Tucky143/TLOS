package net.mcreator.tlos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.tlos.network.TlosModVariables;
import net.mcreator.tlos.TlosMod;

public class SquareRemoteBombRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double TargetY = 0;
		double TargetZ = 0;
		double LookZ = 0;
		double LookY = 0;
		double LookX = 0;
		double Magnitude = 0;
		double Distance = 0;
		double TargetX = 0;
		if (TlosModVariables.MapVariables.get(world).player_holding_remote_bomb) {
			TlosModVariables.MapVariables.get(world).player_holding_remote_bomb = false;
			TlosModVariables.MapVariables.get(world).syncData(world);
			entity.push((sourceentity.getLookAngle().x * 1.5), (sourceentity.getLookAngle().y * 1.5), (sourceentity.getLookAngle().z * 1.5));
		} else {
			TlosModVariables.MapVariables.get(world).player_holding_remote_bomb = true;
			TlosModVariables.MapVariables.get(world).syncData(world);
			new Object() {
				void timedLoop(int current, int total, int ticks) {
					{
						Entity _ent = entity;
						_ent.teleportTo((sourceentity.getX()), (sourceentity.getY() + 1.5), (sourceentity.getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY() + 1.5), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
					}
					if (!TlosModVariables.MapVariables.get(world).player_holding_remote_bomb) {
						if (true) {
							return;
						}
					}
					final int tick2 = ticks;
					TlosMod.queueServerWork(tick2, () -> {
						if (total > current + 1) {
							timedLoop(current + 1, total, tick2);
						}
					});
				}
			}.timedLoop(0, 10000000, 1);
		}
	}
}
