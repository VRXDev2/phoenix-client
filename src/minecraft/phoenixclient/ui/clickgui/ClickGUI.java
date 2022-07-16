package phoenixclient.ui.clickgui;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import phoenixclient.Client;
import phoenixclient.ui.clickgui.comp.ModButton;

public class ClickGUI extends GuiScreen{
	
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		ScaledResolution sr = new ScaledResolution(mc);
		
		Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() - 50, new Color(0,0,0,170).getRGB());
	}
	
	
	@Override
	public void initGui() {
		super.initGui();
		ModButton testMod = new ModButton(1, 240, 100, Client.INSTANCE.hudManager.tsetMod, "Test Mod");
//		ModButton fpsMod = new ModButton(2, 300, 100, Client.INSTANCE.hudManager.fps, "Fps Mod");
//		ModButton keystrokes = new ModButton(3, 240, 50, Client.INSTANCE.hudManager.keystrokes, "Keystrokes Mod");
//		ModButton targetHud = new ModButton(4, 280, 59, Client.INSTANCE.hudManager.targetHud, "TargetHUD Mod");
		this.buttonList.add(testMod);
//		this.buttonList.add(fpsMod);
//		this.buttonList.add(keystrokes);
//		this.buttonList.add(targetHud);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
		
		if (button.id == 1) {
			Client.INSTANCE.hudManager.tsetMod.toggle();
		}
//		 else if (button.id == 2) {
//			Client.INSTANCE.hudManager.fps.toggle();
//		}else if (button.id == 3) {
//			Client.INSTANCE.hudManager.keystrokes.toggle();
//		}else if (button.id == 4) {
//			Client.INSTANCE.hudManager.targetHud.toggle();
//		}
	}
	
	
	
	
	

}
