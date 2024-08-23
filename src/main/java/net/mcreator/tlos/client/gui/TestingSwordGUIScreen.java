package net.mcreator.tlos.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.tlos.world.inventory.TestingSwordGUIMenu;
import net.mcreator.tlos.network.TestingSwordGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TestingSwordGUIScreen extends AbstractContainerScreen<TestingSwordGUIMenu> {
	private final static HashMap<String, Object> guistate = TestingSwordGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox tsi;
	Button button_finish;

	public TestingSwordGUIScreen(TestingSwordGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 127;
		this.imageHeight = 60;
	}

	private static final ResourceLocation texture = new ResourceLocation("tlos:textures/screens/testing_sword_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		tsi.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (tsi.isFocused())
			return tsi.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String tsiValue = tsi.getValue();
		super.resize(minecraft, width, height);
		tsi.setValue(tsiValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		tsi = new EditBox(this.font, this.leftPos + 4, this.topPos + 4, 118, 18, Component.translatable("gui.tlos.testing_sword_gui.tsi")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.tlos.testing_sword_gui.tsi").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.tlos.testing_sword_gui.tsi").getString());
				else
					setSuggestion(null);
			}
		};
		tsi.setMaxLength(32767);
		tsi.setSuggestion(Component.translatable("gui.tlos.testing_sword_gui.tsi").getString());
		guistate.put("text:tsi", tsi);
		this.addWidget(this.tsi);
		button_finish = Button.builder(Component.translatable("gui.tlos.testing_sword_gui.button_finish"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new TestingSwordGUIButtonMessage(0, x, y, z));
				TestingSwordGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 27, 56, 20).build();
		guistate.put("button:button_finish", button_finish);
		this.addRenderableWidget(button_finish);
	}
}
