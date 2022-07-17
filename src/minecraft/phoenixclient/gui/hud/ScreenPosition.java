package phoenixclient.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ScreenPosition {
	
	private static final Minecraft mc = Minecraft.getMinecraft();
	
	private double x,y;
	
	public ScreenPosition(double x, double y) {
		setRelative(x,y);
	}
	
	public ScreenPosition(int x, int y) {
		setAbsolute(x,y);
	}
	
	public static ScreenPosition fromRelativePosition(double x, double y) {
		return new ScreenPosition(x, y);
	}
	
	public static ScreenPosition fromAbsolutePosition(int x, int y) {
		return new ScreenPosition(x, y);
	}
	
	
	public int getAbsoluteX() {
		ScaledResolution sr = new ScaledResolution(mc);
		return (int) (x * sr.getScaledWidth());
	}
	
	public int getAbsoluteY() {
		ScaledResolution sr = new ScaledResolution(mc);
		return (int) (y * sr.getScaledHeight());
	}
	
	
	public double getRelativeX() {
		return x;
	}
	
	public double getRelativeY() {
		return y;
	}
	
	
	public void setRelative(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setAbsolute(int x, int y) {
		ScaledResolution sr = new ScaledResolution(mc);
		this.x = (double) x / sr.getScaledWidth();
		this.y = (double) y / sr.getScaledHeight();
	}

}
