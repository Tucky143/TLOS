package net.mcreator.tlos.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.tlos.world.inventory.SheikahSlateGUIMenu;
import net.mcreator.tlos.network.SheikahSlateGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SheikahSlateGUIScreen extends AbstractContainerScreen<SheikahSlateGUIMenu> {
	private final static HashMap<String, Object> guistate = SheikahSlateGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_remote_bomb;
	ImageButton imagebutton_magnesis;
	ImageButton imagebutton_stasis;
	ImageButton imagebutton_cryonis;
	ImageButton imagebutton_master_cycle_zero;

	public SheikahSlateGUIScreen(SheikahSlateGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 416;
		this.imageHeight = 166;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("tlos:textures/screens/sheikah_slate_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_remote_bomb = new ImageButton(this.leftPos + 36, this.topPos + 70, 64, 64,
				new WidgetSprites(ResourceLocation.parse("tlos:textures/screens/remote_bomb.png"), ResourceLocation.parse("tlos:textures/screens/remote_bomb_hovered.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SheikahSlateGUIButtonMessage(0, x, y, z));
						SheikahSlateGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_remote_bomb", imagebutton_remote_bomb);
		this.addRenderableWidget(imagebutton_remote_bomb);
		imagebutton_magnesis = new ImageButton(this.leftPos + 135, this.topPos + 70, 64, 64, new WidgetSprites(ResourceLocation.parse("tlos:textures/screens/magnesis.png"), ResourceLocation.parse("tlos:textures/screens/magnesis_hovered.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SheikahSlateGUIButtonMessage(1, x, y, z));
				SheikahSlateGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_magnesis", imagebutton_magnesis);
		this.addRenderableWidget(imagebutton_magnesis);
		imagebutton_stasis = new ImageButton(this.leftPos + 225, this.topPos + 70, 64, 64, new WidgetSprites(ResourceLocation.parse("tlos:textures/screens/stasis.png"), ResourceLocation.parse("tlos:textures/screens/stasis_hovered.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SheikahSlateGUIButtonMessage(2, x, y, z));
				SheikahSlateGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_stasis", imagebutton_stasis);
		this.addRenderableWidget(imagebutton_stasis);
		imagebutton_cryonis = new ImageButton(this.leftPos + 315, this.topPos + 70, 64, 64, new WidgetSprites(ResourceLocation.parse("tlos:textures/screens/cryonis.png"), ResourceLocation.parse("tlos:textures/screens/cryonis_hovered.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new SheikahSlateGUIButtonMessage(3, x, y, z));
				SheikahSlateGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_cryonis", imagebutton_cryonis);
		this.addRenderableWidget(imagebutton_cryonis);
		imagebutton_master_cycle_zero = new ImageButton(this.leftPos + 180, this.topPos + -2, 64, 64,
				new WidgetSprites(ResourceLocation.parse("tlos:textures/screens/master_cycle_zero.png"), ResourceLocation.parse("tlos:textures/screens/master_cycle_zero_hovered.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new SheikahSlateGUIButtonMessage(4, x, y, z));
						SheikahSlateGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_master_cycle_zero", imagebutton_master_cycle_zero);
		this.addRenderableWidget(imagebutton_master_cycle_zero);
	}
}
