package net.mcreator.tlos.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tlos.network.TlosModVariables;

public class StasisProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TlosModVariables.PlayerVariables _vars = entity.getData(TlosModVariables.PLAYER_VARIABLES);
			_vars.cryonis_activated = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			TlosModVariables.PlayerVariables _vars = entity.getData(TlosModVariables.PLAYER_VARIABLES);
			_vars.magnesis_activated = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			TlosModVariables.PlayerVariables _vars = entity.getData(TlosModVariables.PLAYER_VARIABLES);
			_vars.remote_bomb_activated = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			TlosModVariables.PlayerVariables _vars = entity.getData(TlosModVariables.PLAYER_VARIABLES);
			_vars.stasis_activated = true;
			_vars.syncPlayerVariables(entity);
		}
		{
			TlosModVariables.PlayerVariables _vars = entity.getData(TlosModVariables.PLAYER_VARIABLES);
			_vars.master_cycle_activated = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}
