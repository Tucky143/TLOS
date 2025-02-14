package net.mcreator.tloa.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.tloa.network.TloaModVariables;
import net.mcreator.tloa.init.TloaModItems;
import net.mcreator.tloa.TloaMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RupeeRightClickedProcedure {
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
		double money = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("tloa:rupee")))
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("tloa:rupee")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TloaModItems.GREEN_RUPEE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TloaModItems.GREEN_RUPEE.get()) {
				{
					TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
					_vars.money = entity.getData(TloaModVariables.PLAYER_VARIABLES).money + 1;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(TloaModItems.GREEN_RUPEE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TloaModItems.BLUE_RUPEE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TloaModItems.BLUE_RUPEE.get()) {
				{
					TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
					_vars.money = entity.getData(TloaModVariables.PLAYER_VARIABLES).money + 5;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(TloaModItems.BLUE_RUPEE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TloaModItems.RED_RUPEE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TloaModItems.RED_RUPEE.get()) {
				{
					TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
					_vars.money = entity.getData(TloaModVariables.PLAYER_VARIABLES).money + 20;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(TloaModItems.RED_RUPEE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TloaModItems.PURPLE_RUPEE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TloaModItems.PURPLE_RUPEE.get()) {
				{
					TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
					_vars.money = entity.getData(TloaModVariables.PLAYER_VARIABLES).money + 50;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(TloaModItems.PURPLE_RUPEE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TloaModItems.SILVER_RUPEE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TloaModItems.SILVER_RUPEE.get()) {
				{
					TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
					_vars.money = entity.getData(TloaModVariables.PLAYER_VARIABLES).money + 100;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(TloaModItems.SILVER_RUPEE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TloaModItems.GOLD_RUPEE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TloaModItems.GOLD_RUPEE.get()) {
				{
					TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
					_vars.money = entity.getData(TloaModVariables.PLAYER_VARIABLES).money + 300;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(TloaModItems.GOLD_RUPEE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("tloa:rupee_added")), SoundSource.PLAYERS, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("tloa:rupee_added")), SoundSource.PLAYERS, (float) 0.5, 1, false);
				}
			}
			if (false == entity.getData(TloaModVariables.PLAYER_VARIABLES).RupeeCounterOn) {
				{
					TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
					_vars.RupeeCounterOn = true;
					_vars.syncPlayerVariables(entity);
				}
				TloaMod.queueServerWork(60, () -> {
					{
						TloaModVariables.PlayerVariables _vars = entity.getData(TloaModVariables.PLAYER_VARIABLES);
						_vars.RupeeCounterOn = false;
						_vars.syncPlayerVariables(entity);
					}
				});
			}
		}
	}
}
