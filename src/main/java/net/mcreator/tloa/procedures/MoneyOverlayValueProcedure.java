package net.mcreator.tloa.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.network.TloaModVariables;

public class MoneyOverlayValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(TloaModVariables.PLAYER_VARIABLES).money <= 9999 ? new java.text.DecimalFormat("##").format(entity.getData(TloaModVariables.PLAYER_VARIABLES).money) : "9999";
	}
}
