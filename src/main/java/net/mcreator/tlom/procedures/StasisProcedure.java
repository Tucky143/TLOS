package net.mcreator.tlom.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tlom.network.TlomModVariables;

public class StasisProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TlomModVariables.PlayerVariables _vars = entity.getData(TlomModVariables.PLAYER_VARIABLES);
			_vars.cryonis_activated = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			TlomModVariables.PlayerVariables _vars = entity.getData(TlomModVariables.PLAYER_VARIABLES);
			_vars.magnesis_activated = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			TlomModVariables.PlayerVariables _vars = entity.getData(TlomModVariables.PLAYER_VARIABLES);
			_vars.remote_bomb_activated = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			TlomModVariables.PlayerVariables _vars = entity.getData(TlomModVariables.PLAYER_VARIABLES);
			_vars.stasis_activated = true;
			_vars.syncPlayerVariables(entity);
		}
		{
			TlomModVariables.PlayerVariables _vars = entity.getData(TlomModVariables.PLAYER_VARIABLES);
			_vars.master_cycle_activated = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}
