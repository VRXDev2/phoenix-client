package phoenixclient;

import net.minecraft.client.Minecraft;
import phoenixclient.event.EventManager;
import phoenixclient.event.EventTarget;
import phoenixclient.event.impl.ClientTick;
import phoenixclient.hud.HudConfigGui;
import phoenixclient.hud.mod.HudManager;

public class Client {

	public final String NAME = "Phoenix Client";
	public final String VERSION = "1.0.0";
	public final String AUTHOR = "VRXDev, asem__1425";
	public EventManager eventManager;
	public HudManager hudManager;
	public Minecraft mc = Minecraft.getMinecraft();
	
	public static Client INSTANCE = new Client();
	
	public DiscordRP discordRP = new DiscordRP();
	
	public void startup() {
		eventManager = new EventManager();
		hudManager = new HudManager();
		discordRP.start();
		//SplashScreen.setProgress(1, "Discord RPC");
		eventManager.register(this);
		System.out.println("Starting " + NAME + " " + VERSION);
	}
	
	public void shutdown() {
		eventManager.unregister(this);
		discordRP.shutdown();
		System.out.println("Stopping " + NAME + " " + VERSION);
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
	
	
	@EventTarget
	public void onTick(ClientTick e) {
		if (mc.gameSettings.HUD_GUI.isPressed()) {
			mc.displayGuiScreen(new HudConfigGui());
		}
	}
}
