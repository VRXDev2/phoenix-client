package phoenixclient;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import net.minecraft.client.Minecraft;
import phoenixclient.event.EventManager;
import phoenixclient.event.EventTarget;
import phoenixclient.event.impl.ClientTick;
import phoenixclient.gui.hud.HUDManager;
import phoenixclient.mods.ModInstances;
import phoenixclient.util.font.FontUtil;

public class Client {

	public final String NAME = "Phoenix Client";
	public final String VERSION = "1.0.0";
	public final String AUTHOR = "VRXDev, asem__1425";
	public EventManager eventManager;
	public Minecraft mc = Minecraft.getMinecraft();
	private HUDManager hudManager;
	
	public static Client INSTANCE = new Client();
	
	public DiscordRP discordRP = new DiscordRP();
	
	public void startup() {
		eventManager = new EventManager();
		discordRP.start();
		FontUtil.bootstrap();
		eventManager.register(this);
		System.out.println("Starting " + NAME + " " + VERSION);
	}
	
	public void start() {
		hudManager = HUDManager.getInstance();
		ModInstances.register(hudManager);
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
			hudManager.openConfigScreen();
		}
	}
}
