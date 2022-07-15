package phoenixclient.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import phoenixclient.hud.mod.HudMod;

public class TestMod extends HudMod{
	
	public TestMod() {
		super("testMod", 5, 5);
	}
	
	@Override
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0,170).getRGB());
		fr.drawString(name, getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawString(name, getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return fr.getStringWidth(name);
	}
	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return fr.FONT_HEIGHT;
	}

}
