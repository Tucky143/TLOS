package net.mcreator.tloa.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class GlidingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-0.25), (entity.getDeltaMovement().z())));
			entity.fallDistance = 1;
		} else {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-0.05), (entity.getDeltaMovement().z())));
			entity.fallDistance = 1;
		}
	}
}
