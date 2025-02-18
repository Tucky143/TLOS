package net.mcreator.tloa.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.tloa.network.TloaModVariables;
import net.mcreator.tloa.TloaMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StaminaDrainProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (getEntityGameType(entity) == GameType.ADVENTURE || getEntityGameType(entity) == GameType.SURVIVAL) {
			if (entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina <= 0) {
				{
					TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
					_vars.current_player_stamina = entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina + 0.5;
					_vars.syncPlayerVariables(entity);
				}
				if (entity.isSprinting()) {
					entity.setSprinting(false);
				}
				if (entity.getData(TloaModVariables.PLAYER_VARIABLES).climbing) {
					{
						TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
						_vars.climbing = false;
						_vars.syncPlayerVariables(entity);
					}
				}
				if (entity.getData(TloaModVariables.PLAYER_VARIABLES).bullet_time_active) {
					{
						TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
						_vars.bullet_time_active = false;
						_vars.syncPlayerVariables(entity);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1, 1, false, false));
				{
					TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
					_vars.can_stamina_drain = false;
					_vars.syncPlayerVariables(entity);
				}
			} else if (false == entity.getData(TloaModVariables.PLAYER_VARIABLES).can_stamina_drain) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1, 1, false, false));
				if (entity.isSprinting()) {
					entity.setSprinting(false);
					if (entity.isSwimming()) {
						entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1, 1, false, false));
					}
				}
				if (entity.getData(TloaModVariables.PLAYER_VARIABLES).climbing) {
					{
						TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
						_vars.climbing = false;
						_vars.syncPlayerVariables(entity);
					}
				}
				if (entity.getData(TloaModVariables.PLAYER_VARIABLES).bullet_time_active) {
					{
						TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
						_vars.bullet_time_active = false;
						_vars.syncPlayerVariables(entity);
					}
				}
				if (entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina < entity.getData(TloaModVariables.PLAYER_VARIABLES).max_player_stamina) {
					{
						TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
						_vars.current_player_stamina = entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina + 0.5;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else if (entity.getData(TloaModVariables.PLAYER_VARIABLES).can_stamina_drain) {
				if (entity.isSprinting()) {
					{
						TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
						_vars.current_player_stamina = entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina - 0.5;
						_vars.syncPlayerVariables(entity);
					}
					entity.setSprinting(true);
				} else if (entity.getData(TloaModVariables.PLAYER_VARIABLES).climbing) {
					{
						TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
						_vars.current_player_stamina = entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina - 0.3;
						_vars.syncPlayerVariables(entity);
					}
				} else if (entity.getData(TloaModVariables.PLAYER_VARIABLES).bullet_time_active) {
					{
						TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
						_vars.current_player_stamina = entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina - 3;
						_vars.syncPlayerVariables(entity);
					}
				} else {
					if (entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina < entity.getData(TloaModVariables.PLAYER_VARIABLES).max_player_stamina) {
						{
							TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
							_vars.current_player_stamina = entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina + 0.5;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
			}
			if (entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina >= 40) {
				{
					TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
					_vars.can_stamina_drain = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			TloaMod.LOGGER.info(("Current Stamina:" + new java.text.DecimalFormat("##.#").format(entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina)));
			TloaMod.LOGGER.info(("Rounded Stamina" + new java.text.DecimalFormat("##.##").format(Math.round(entity.getData(TloaModVariables.PLAYER_VARIABLES).current_player_stamina))));
			TloaMod.LOGGER.info(("Can Stamina:" + entity.getData(TloaModVariables.PLAYER_VARIABLES).can_stamina_drain));
			TloaMod.LOGGER.info(("Max Stamina" + entity.getData(TloaModVariables.PLAYER_VARIABLES).max_player_stamina));
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
