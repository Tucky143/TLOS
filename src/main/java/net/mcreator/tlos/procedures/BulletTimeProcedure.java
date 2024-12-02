package net.mcreator.tlos.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.tlos.network.TlosModVariables;
import net.mcreator.tlos.TlosMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BulletTimeProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("minecraft:enchantable/crossbow")))
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("minecraft:enchantable/bow")))) {
			if (!entity.onGround()) {
				new Object() {
					void timedLoop(int current, int total, int ticks) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("minecraft:enchantable/crossbow")))
								|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("minecraft:enchantable/bow")))) {
							if (!entity.onGround()) {
								TlosModVariables.MapVariables.get(world).bullet_time_active = true;
								TlosModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 15, false, false));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands()
											.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "tick rate 5");
							} else {
								TlosModVariables.MapVariables.get(world).bullet_time_active = false;
								TlosModVariables.MapVariables.get(world).syncData(world);
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands()
											.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "tick rate 20");
								if (true) {
									return;
								}
							}
						} else {
							TlosModVariables.MapVariables.get(world).bullet_time_active = false;
							TlosModVariables.MapVariables.get(world).syncData(world);
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"tick rate 20");
							if (true) {
								return;
							}
						}
						final int tick2 = ticks;
						TlosMod.queueServerWork(tick2, () -> {
							if (total > current + 1) {
								timedLoop(current + 1, total, tick2);
							}
						});
					}
				}.timedLoop(0, 100000000, 1);
			}
		}
	}
}
