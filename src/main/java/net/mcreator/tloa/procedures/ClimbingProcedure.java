package net.mcreator.tloa.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.tloa.network.TloaModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ClimbingProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TloaModVariables.PLAYER_VARIABLES).climbing) {
			if ((world.getBlockState(BlockPos.containing(x, y, z - 0.35))).is(BlockTags.create(ResourceLocation.parse("tloa:climbable")))) {
				entity.push(0, 0.08, 0);
				entity.fallDistance = 2;
			} else if ((world.getBlockState(BlockPos.containing(x, y, z + 0.35))).is(BlockTags.create(ResourceLocation.parse("tloa:climbable")))) {
				entity.push(0, 0.08, 0);
				entity.fallDistance = 2;
			} else if ((world.getBlockState(BlockPos.containing(x - 0.35, y, z))).is(BlockTags.create(ResourceLocation.parse("tloa:climbable")))) {
				entity.push(0, 0.08, 0);
				entity.fallDistance = 2;
			} else if ((world.getBlockState(BlockPos.containing(x + 0.35, y, z))).is(BlockTags.create(ResourceLocation.parse("tloa:climbable")))) {
				entity.push(0, 0.08, 0);
				entity.fallDistance = 2;
			}
		}
	}
}
