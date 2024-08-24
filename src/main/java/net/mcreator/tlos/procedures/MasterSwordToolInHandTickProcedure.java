package net.mcreator.tlos.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.tlos.init.TlosModItems;

public class MasterSwordToolInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((world instanceof Level _lvl0 && _lvl0.isDay()) == false) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TlosModItems.MASTER_SWORD.get()) {
				if (itemstack.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
					ItemStack _setstack = new ItemStack(TlosModItems.MASTER_SWORD_POWERED.get()).copy();
					_setstack.setCount(1);
					_modHandlerItemSetSlot.setStackInSlot(98, _setstack);
				}
			}
		}
	}
}
