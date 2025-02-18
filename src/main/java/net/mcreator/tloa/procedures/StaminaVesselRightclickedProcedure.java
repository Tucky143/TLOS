package net.mcreator.tloa.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.network.TloaModVariables;

public class StaminaVesselRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(TloaModVariables.PLAYER_VARIABLES).max_player_stamina < 140) {
			{
				TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
				_vars.max_player_stamina = entity.getData(TloaModVariables.PLAYER_VARIABLES).max_player_stamina + 10;
				_vars.syncPlayerVariables(entity);
			}
			{
				TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
				_vars.current_player_stamina = entity.getData(TloaModVariables.PLAYER_VARIABLES).max_player_stamina;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
			itemstack.shrink(1);
		}
	}
}
