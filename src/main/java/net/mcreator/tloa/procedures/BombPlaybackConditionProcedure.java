package net.mcreator.tloa.procedures;

import net.minecraft.world.entity.Entity;

public class BombPlaybackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean ignited = false;
		if (entity.getPersistentData().getBoolean("ignited")) {
			ignited = true;
		}
		return ignited;
	}
}
