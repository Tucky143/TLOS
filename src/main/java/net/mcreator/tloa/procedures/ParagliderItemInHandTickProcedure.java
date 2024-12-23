package net.mcreator.tloa.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class ParagliderItemInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			GlidingProcedure.execute(entity);
		}
	}
}
