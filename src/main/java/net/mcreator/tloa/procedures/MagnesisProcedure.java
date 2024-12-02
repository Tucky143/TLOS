package net.mcreator.tloa.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.network.TloaModVariables;

public class MagnesisProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean CryonisActive = false;
		{
			TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
			_vars.cryonis_activated = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
			_vars.magnesis_activated = true;
			_vars.syncPlayerVariables(entity);
		}
		{
			TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
			_vars.remote_bomb_activated = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
			_vars.stasis_activated = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
			_vars.master_cycle_activated = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}
