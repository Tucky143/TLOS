package net.mcreator.tloa.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.tloa.init.TloaModItems;
import net.mcreator.tloa.TloaMod;

public class SheikahSlateOnItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TloaMod.queueServerWork(200, () -> {
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TloaModItems.SHEIKAH_SLATE_ON.get())) : false) && TloaModItems.SHEIKAH_SLATE_ON.get() == itemstackiterator.getItem()) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(TloaModItems.SHEIKAH_SLATE.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(TloaModItems.SHEIKAH_SLATE_ON.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
				}
			}
		});
	}
}
