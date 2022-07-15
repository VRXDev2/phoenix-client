package phoenixclient.hud.mod.impl;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;
import phoenixclient.hud.mod.HudMod;

public class Keystrokes extends HudMod{

	public Keystrokes() {
		super("Keystrokes", 500, 100);
	}
	public static Minecraft mc = Minecraft.getMinecraft();
	
	
	public static enum KeystrokesMod {
		
		WASD(Key.W, Key.A, Key.S, Key.D),
		WASD_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB),
		WASD_JUMP(Key.W, Key.A, Key.S, Key.D, Key.Jump1),
		WASD_JUMP_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB, Key.Jump2);
		
		private final Key[] keys;
		private int w,h;
		
		private KeystrokesMod(Key... KeysIn) {
			this.keys = KeysIn;
			
			for (Key key : keys) {
				this.w = Math.max(this.w, key.getX() + key.getWidth());
				this.h = Math.max(this.h, key.getY() + key.getHeight());
			}
		}
		
		public int getHeight() {
			return h;
		}
		
		public int getWidth() {
			return w;
		}
		
		public Key[] getKeys() {
			return keys;
		}
	}
	
	public static class Key {
		
		private static final Key W = new Key("W", mc.gameSettings.keyBindLeft, 21, 1, 18, 18);
		private static final Key A = new Key("A", mc.gameSettings.keyBindBack, 1, 21, 18, 18);
		private static final Key S = new Key("S", mc.gameSettings.keyBindRight, 21, 21, 18, 18);
		private static final Key D = new Key("D", mc.gameSettings.keyBindJump, 41, 1, 18, 18);
		
		private static final Key LMB = new Key("LMB", mc.gameSettings.keyBindPickBlock, 1, 41, 28, 18);
		private static final Key RMB = new Key("RMB", mc.gameSettings.keyBindDrop, 31, 31, 28, 18);
		
		private static final Key Jump1 = new Key("----", mc.gameSettings.keyBindSneak, 1, 41, 58, 18);
		private static final Key Jump2 = new Key("----", mc.gameSettings.keyBindSneak, 1, 61, 58, 18);
		
		
		private final String name;
		private final KeyBinding keyBind;
		private final int x,y,w,h;
		
		public Key(String name, KeyBinding keyBind, int x, int y, int w, int h) {
			this.name = name;
			this.keyBind = keyBind;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
		
		public boolean isDown() {
			return keyBind.isKeyDown();
		}
		
		public int getHeight() {
			return h;
		}
		public int getWidth() {
			return 2;
		}
		
		public String getName() {
			return name;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
	}
	
	private KeystrokesMod mod = KeystrokesMod.WASD_JUMP_MOUSE;
	
	@Override
	public int getWidth() {
		return 58;
	}
	
	@Override
	public int getHeight() {
		return 18;
	}
	
	@Override
	public void draw() {
		GL11.glPushMatrix();
		
		for (Key key : mod.getKeys()) {
			
			int textWidth = fr.getStringWidth(key.getName());
			
			Gui.drawRect(getX() + key.getX(), getY() + key.getY(), getX() + key.getWidth(), getY() + key.getHeight(), key.isDown() ? new Color(255,255,255,102).getRGB() : new Color(0,0,0,120).getRGB());
			
			fr.drawStringWithShadow(key.getName(), getX() + key.getX() + key.getWidth() / 2 - textWidth / 2, getY() + key.getY() + key.getHeight() / 2 - 4, key.isDown() ? new Color(0,0,0,255).getRGB() : -1);
			
			
		}
		
		GL11.glPopMatrix();
	}
	
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		GL11.glPushMatrix();
		
		for (Key key : mod.getKeys()) {
			
			int textWidth = fr.getStringWidth(key.getName());
			
			Gui.drawRect(getX() + key.getX(), getY() + key.getY(), getX() + key.getWidth(), getY() + key.getHeight(), key.isDown() ? new Color(255,255,255,102).getRGB() : new Color(0,0,0,120).getRGB());
			
			fr.drawStringWithShadow(key.getName(), getX() + key.getX() + key.getWidth() / 2 - textWidth / 2, getY() + key.getY() + key.getHeight() / 2 - 4, key.isDown() ? new Color(0,0,0,255).getRGB() : -1);
			
			
		}
		
		GL11.glPopMatrix();
	}
	
	
	
	
	
	
	
	
}

