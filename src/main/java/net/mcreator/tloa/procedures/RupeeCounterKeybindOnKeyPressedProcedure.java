package net.mcreator.tloa.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.network.TloaModVariables;

public class RupeeCounterKeybindOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TloaModVariables.PLAYER_VARIABLES).RupeeCounterOn) {
			{
				TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
				_vars.RupeeCounterOn = false;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
				_vars.RupeeCounterOn = true;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
