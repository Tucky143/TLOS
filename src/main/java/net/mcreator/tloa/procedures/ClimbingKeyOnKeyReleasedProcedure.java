package net.mcreator.tloa.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.network.TloaModVariables;

public class ClimbingKeyOnKeyReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
			_vars.climbing_key_pressed = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
			_vars.climbing = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}
