package net.mcreator.tloa.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.tloa.TloaMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TloaModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, TloaMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		TloaMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.climbing = original.climbing;
			clone.RupeeCounterOn = original.RupeeCounterOn;
			clone.max_player_health = original.max_player_health;
			clone.max_player_stamina = original.max_player_stamina;
			clone.climbing_key_pressed = original.climbing_key_pressed;
			if (!event.isWasDeath()) {
				clone.cryonis_activated = original.cryonis_activated;
				clone.magnesis_activated = original.magnesis_activated;
				clone.remote_bomb_activated = original.remote_bomb_activated;
				clone.stasis_activated = original.stasis_activated;
				clone.master_cycle_activated = original.master_cycle_activated;
				clone.player_holding_remote_bomb = original.player_holding_remote_bomb;
				clone.bullet_time_active = original.bullet_time_active;
				clone.money = original.money;
				clone.magnesis_active = original.magnesis_active;
				clone.current_player_stamina = original.current_player_stamina;
				clone.can_stamina_drain = original.can_stamina_drain;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public boolean cryonis_activated = false;
		public boolean magnesis_activated = false;
		public boolean remote_bomb_activated = false;
		public boolean stasis_activated = false;
		public boolean master_cycle_activated = false;
		public boolean player_holding_remote_bomb = false;
		public boolean bullet_time_active = false;
		public double money = 0.0;
		public boolean climbing = false;
		public boolean RupeeCounterOn = true;
		public boolean magnesis_active = false;
		public double max_player_health = 14.0;
		public double max_player_stamina = 40.0;
		public double current_player_stamina = 40.0;
		public boolean can_stamina_drain = true;
		public boolean climbing_key_pressed = false;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("cryonis_activated", cryonis_activated);
			nbt.putBoolean("magnesis_activated", magnesis_activated);
			nbt.putBoolean("remote_bomb_activated", remote_bomb_activated);
			nbt.putBoolean("stasis_activated", stasis_activated);
			nbt.putBoolean("master_cycle_activated", master_cycle_activated);
			nbt.putBoolean("player_holding_remote_bomb", player_holding_remote_bomb);
			nbt.putBoolean("bullet_time_active", bullet_time_active);
			nbt.putDouble("money", money);
			nbt.putBoolean("climbing", climbing);
			nbt.putBoolean("RupeeCounterOn", RupeeCounterOn);
			nbt.putBoolean("magnesis_active", magnesis_active);
			nbt.putDouble("max_player_health", max_player_health);
			nbt.putDouble("max_player_stamina", max_player_stamina);
			nbt.putDouble("current_player_stamina", current_player_stamina);
			nbt.putBoolean("can_stamina_drain", can_stamina_drain);
			nbt.putBoolean("climbing_key_pressed", climbing_key_pressed);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			cryonis_activated = nbt.getBoolean("cryonis_activated");
			magnesis_activated = nbt.getBoolean("magnesis_activated");
			remote_bomb_activated = nbt.getBoolean("remote_bomb_activated");
			stasis_activated = nbt.getBoolean("stasis_activated");
			master_cycle_activated = nbt.getBoolean("master_cycle_activated");
			player_holding_remote_bomb = nbt.getBoolean("player_holding_remote_bomb");
			bullet_time_active = nbt.getBoolean("bullet_time_active");
			money = nbt.getDouble("money");
			climbing = nbt.getBoolean("climbing");
			RupeeCounterOn = nbt.getBoolean("RupeeCounterOn");
			magnesis_active = nbt.getBoolean("magnesis_active");
			max_player_health = nbt.getDouble("max_player_health");
			max_player_stamina = nbt.getDouble("max_player_stamina");
			current_player_stamina = nbt.getDouble("current_player_stamina");
			can_stamina_drain = nbt.getBoolean("can_stamina_drain");
			climbing_key_pressed = nbt.getBoolean("climbing_key_pressed");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TloaMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
