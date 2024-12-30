
package net.mcreator.tloa.network;

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
import net.minecraft.core.BlockPos;

import net.mcreator.tloa.world.inventory.SheikahSlateGUIMenu;
import net.mcreator.tloa.procedures.StasisProcedure;
import net.mcreator.tloa.procedures.RemoteBombsProcedure;
import net.mcreator.tloa.procedures.MasterCycleProcedure;
import net.mcreator.tloa.procedures.MagnesisProcedure;
import net.mcreator.tloa.procedures.CryonisProcedure;
import net.mcreator.tloa.TloaMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SheikahSlateGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<SheikahSlateGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TloaMod.MODID, "sheikah_slate_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SheikahSlateGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SheikahSlateGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SheikahSlateGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<SheikahSlateGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SheikahSlateGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SheikahSlateGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			RemoteBombsProcedure.execute(entity);
		}
		if (buttonID == 1) {

			MagnesisProcedure.execute(entity);
		}
		if (buttonID == 2) {

			CryonisProcedure.execute(entity);
		}
		if (buttonID == 3) {

			MasterCycleProcedure.execute(entity);
		}
		if (buttonID == 4) {

			StasisProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TloaMod.addNetworkMessage(SheikahSlateGUIButtonMessage.TYPE, SheikahSlateGUIButtonMessage.STREAM_CODEC, SheikahSlateGUIButtonMessage::handleData);
	}
}
