package phoenixclient.hud;

import net.minecraft.client.gui.GuiScreen;
import phoenixclient.Client;
import phoenixclient.hud.mod.HudMod;

public class HudConfigGui extends GuiScreen{
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		for (HudMod m  : Client.INSTANCE.hudManager.hudMods) {
			if (m.isEnabled()) {
				m.renderDummy(mouseX, mouseY);
			}
		}
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
}
