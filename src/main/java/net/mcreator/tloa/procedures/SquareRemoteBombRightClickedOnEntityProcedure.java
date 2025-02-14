package net.mcreator.tloa.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.network.TloaModVariables;

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
		if (TloaModVariables.MapVariables.get(world).player_holding_remote_bomb) {
			TloaModVariables.MapVariables.get(world).player_holding_remote_bomb = false;
			TloaModVariables.MapVariables.get(world).syncData(world);
			entity.push((sourceentity.getLookAngle().x * 1.8), (sourceentity.getLookAngle().y * 2), (sourceentity.getLookAngle().z * 1.8));
		} else {
			TloaModVariables.MapVariables.get(world).player_holding_remote_bomb = true;
			TloaModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
