package net.mcreator.tlom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.tlom.network.TlomModVariables;

public class UseRuneOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double CX = 0;
		double CY = 0;
		double CZ = 0;
		if (entity.getData(TlomModVariables.PLAYER_VARIABLES).cryonis_activated) {
			CryonisAbilityProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getData(TlomModVariables.PLAYER_VARIABLES).master_cycle_activated) {
			MasterCycleAbilityProcedure.execute(world, x, y, z);
		}
		if (entity.getData(TlomModVariables.PLAYER_VARIABLES).remote_bomb_activated) {
			RemoteBombAbilityProcedure.execute(world, x, y, z, entity);
		}
		if (entity.getData(TlomModVariables.PLAYER_VARIABLES).stasis_activated) {
			StasisAbilityProcedure.execute(world, x, y, z);
		}
	}
}
