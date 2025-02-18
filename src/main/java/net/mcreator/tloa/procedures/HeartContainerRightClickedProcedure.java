package net.mcreator.tloa.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.network.TloaModVariables;

public class HeartContainerRightClickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(TloaModVariables.PLAYER_VARIABLES).max_player_health < 60) {
			{
				TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
				_vars.max_player_health = entity.getData(TloaModVariables.PLAYER_VARIABLES).max_player_health + 2;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) entity.getData(TloaModVariables.PLAYER_VARIABLES).max_player_health);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
			itemstack.shrink(1);
		}
	}
}
