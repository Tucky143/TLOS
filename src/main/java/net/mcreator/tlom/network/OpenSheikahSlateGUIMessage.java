
package net.mcreator.tlom.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.tlom.procedures.OpenSheikahSlateGUIOnKeyPressedProcedure;
import net.mcreator.tlom.TlomMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record OpenSheikahSlateGUIMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<OpenSheikahSlateGUIMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TlomMod.MODID, "key_open_sheikah_slate_gui"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenSheikahSlateGUIMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenSheikahSlateGUIMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenSheikahSlateGUIMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenSheikahSlateGUIMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenSheikahSlateGUIMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			OpenSheikahSlateGUIOnKeyPressedProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TlomMod.addNetworkMessage(OpenSheikahSlateGUIMessage.TYPE, OpenSheikahSlateGUIMessage.STREAM_CODEC, OpenSheikahSlateGUIMessage::handleData);
	}
}
