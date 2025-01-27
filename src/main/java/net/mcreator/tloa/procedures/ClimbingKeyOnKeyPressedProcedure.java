package net.mcreator.tloa.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.network.TloaModVariables;

public class ClimbingKeyOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
			_vars.climbing = true;
			_vars.syncPlayerVariables(entity);
		}
	}
}
