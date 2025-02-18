package net.mcreator.tloa.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.network.TloaModVariables;

public class StaminaWheelOverlayDrainProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return Math.round(entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina / 10) <= entity.getData(TloaModVariables.PLAYER_VARIABLES).max_player_stamina / 10
				? Math.round(entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina / 10)
				: 1;
	}
}
