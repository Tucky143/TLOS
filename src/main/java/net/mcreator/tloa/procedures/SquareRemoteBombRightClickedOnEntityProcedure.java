package net.mcreator.tloa.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.network.TloaModVariables;

public class SquareRemoteBombRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
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
		if (entity.getData(TloaModVariables.PLAYER_VARIABLES).player_holding_remote_bomb) {
			entity.push((sourceentity.getLookAngle().x * 1.8), (sourceentity.getLookAngle().y * 2), (sourceentity.getLookAngle().z * 1.8));
			{
				TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
				_vars.player_holding_remote_bomb = false;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
				_vars.player_holding_remote_bomb = true;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
