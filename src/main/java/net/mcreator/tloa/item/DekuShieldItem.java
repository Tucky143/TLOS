
package net.mcreator.tloa.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.tloa.init.TloaModBlocks;

public class DekuShieldItem extends ShieldItem {
	public DekuShieldItem() {
		super(new Item.Properties().durability(402));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(TloaModBlocks.DEKU_PLANKS.get())).test(repairitem);
	}
}
