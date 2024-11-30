package net.mcreator.tlos.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.tlos.network.TlosModVariables;

public class UseRuneOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double CX = 0;
		double CY = 0;
		double CZ = 0;
		if (entity.getData(TlosModVariables.PLAYER_VARIABLES).cryonis_activated) {
			CryonisAbilityProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getData(TlosModVariables.PLAYER_VARIABLES).master_cycle_activated) {
			MasterCycleAbilityProcedure.execute(world, x, y, z);
		}
		if (entity.getData(TlosModVariables.PLAYER_VARIABLES).remote_bomb_activated) {
			RemoteBombAbilityProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getData(TlosModVariables.PLAYER_VARIABLES).stasis_activated) {
			StasisAbilityProcedure.execute(world, x, y, z);
		}
	}
}
