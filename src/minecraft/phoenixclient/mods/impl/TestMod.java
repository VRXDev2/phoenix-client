package phoenixclient.mods.impl;

import phoenixclient.gui.hud.ScreenPosition;
import phoenixclient.mods.ModDraggable;

public class TestMod extends ModDraggable{
	
	private ScreenPosition pos;

	@Override
	public int getWidth() {
		return (int) font.getStringWidth("Test Mod");
	}

	@Override
	public int getHeight() {
		return font.getHeight();
	}

	@Override
	public void render(ScreenPosition pos) {
		font.drawString("Test Mod", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, -1);
	}
	
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		font.drawString("Test Mod", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0xFF00FF00);
	}

	@Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
	}

	@Override
	public ScreenPosition load() {
		return pos; 
	}

}
