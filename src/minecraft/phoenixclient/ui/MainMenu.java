package phoenixclient.ui;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import phoenixclient.Client;

public class MainMenu extends GuiScreen{

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("client/background.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(3, 3, 1);
		// if u can fix this x, y lol
//		this.drawString(fontRendererObj, "Phoenix Client", 390, height / 2 - 50, -1);
		GlStateManager.translate(-(width/2f), -(height/2f), 0);
		GlStateManager.popMatrix();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		// Add The GUI Buttons
	    this.buttonList.add(new GuiButton(1, 390, height / 2 - 35, "SinglePlayer"));
	    this.buttonList.add(new GuiButton(2, 390, height / 2 - 12, "MultiPlayer"));
	    this.buttonList.add(new GuiButton(3, 390, height / 2 + 12, "Options"));
	    this.buttonList.add(new GuiButton(4, 390, height / 2 + 35, "Quit"));
		super.initGui();
	}
	
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		// Handle When Someone Click Any Button By Thier ID
		if (button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		} else if (button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		} else if (button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		} else if (button.id == 4) {
			mc.shutdown();
		} 
		super.actionPerformed(button);
	}
	
	
}
