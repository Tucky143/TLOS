package net.mcreator.tlom.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.tlom.init.TlomModItems;

public class SheikahSlateRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(TlomModItems.SHEIKAH_SLATE_ON.get()).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(TlomModItems.SHEIKAH_SLATE.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 64, _player.inventoryMenu.getCraftSlots());
		}
	}
}
