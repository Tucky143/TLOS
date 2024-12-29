package net.mcreator.tloa.procedures;

import net.minecraft.world.entity.Entity;

public class FlamebladeLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.igniteForSeconds(3);
	}
}
