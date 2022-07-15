package phoenixclient.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import phoenixclient.hud.mod.HudMod;

public class PingMod extends HudMod{
	
	public PingMod() {
		super("PingMod", 200, 200);
	}
	
	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0,170).getRGB());
		fr.drawStringWithShadow("§7[§6Ping§7:§f " + getPing() + "§7]", getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawStringWithShadow("§7[§6Ping§7:§f " + getPing() + "§7]", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return fr.getStringWidth("§7[§6Ping§7:§f " + getPing() + "§7]");
	}
	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return fr.FONT_HEIGHT;
	}
	
	public int getPing() {
		if (mc.getCurrentServerData() != null && mc.getCurrentServerData().playerList != null) {
			return (int) mc.getCurrentServerData().pingToServer;
		}
		return 0;
	}

}
