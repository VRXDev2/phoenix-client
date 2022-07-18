package phoenixclient.mods.impl;

import javax.swing.text.JTextComponent.KeyBinding;

import phoenixclient.gui.hud.ScreenPosition;
import phoenixclient.mods.ModDraggable;

public class ModKeystrokes extends ModDraggable {

	private static class Key {
		
		private final String name;
		private final KeyBinding keyBind;
		private final int x;
		private final int y;
		private final int width;
		private final int height;
	
		public Key(String name, KeyBinding keyBind, int x, int y, int width, int height) {
			this.name = name;
			this.keyBind = keyBind;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;	
		}
		
		public boolean isDown() {
			return keyBind.isKeyDown();
		}
		
	}
	
	private ScreenPosition pos;
	
	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public void render(ScreenPosition pos) {
		
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
