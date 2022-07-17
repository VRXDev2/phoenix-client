package phoenixclient.mods;

import phoenixclient.gui.hud.IRenderer;
import phoenixclient.gui.hud.ScreenPosition;

public abstract class ModDraggable extends Mod implements IRenderer{
	
	 public final int getLineOffset(ScreenPosition pos, int lineNum) {
		 return pos.getAbsoluteY() + getLineOffset(lineNum);
	 }
	 
	 private int getLineOffset(int lineNum) {
		 return (font.getHeight() + 3) * lineNum;
	 }

}
