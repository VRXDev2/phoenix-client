package phoenixclient.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import phoenixclient.Client;
import phoenixclient.event.EventManager;
import phoenixclient.util.font.FontUtil;
import phoenixclient.util.font.MinecraftFontRenderer;

public class Mod {
	
	private boolean isEnabled = true;
	
	protected final Minecraft mc;
	protected final MinecraftFontRenderer font;
	protected final Client client;
	
	public Mod() {
		this.mc = Minecraft.getMinecraft();
		this.font = FontUtil.normal;
		this.client = Client.INSTANCE;
		
		setEnabled(isEnabled);
	}
	
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
		
		if (isEnabled) {
			EventManager.register(this);
		} else {
			EventManager.unregister(this);
		}
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}

}
