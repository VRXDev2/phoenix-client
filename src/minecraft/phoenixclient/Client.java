package phoenixclient;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import net.minecraft.client.Minecraft;
import phoenixclient.event.EventManager;
import phoenixclient.event.EventTarget;
import phoenixclient.event.impl.ClientTick;
import phoenixclient.hud.HudConfigGui;
import phoenixclient.hud.mod.HudManager;
import phoenixclient.util.font.FontUtil;

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
		Display.setTitle(NAME + " v" + VERSION + " 1.8.9");
		try {
			Display.setFullscreen(true);
			// If It's Not FHD Make It FHD (Temporally Fix For The Resolution Bug).
			if (!(Display.getDisplayMode().getWidth() == 1920) && !(Display.getDisplayMode().getHeight() == 1080)) {
				Display.setDisplayMode(new DisplayMode(1920, 1080));
				Display.setResizable(false);
			}
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		eventManager = new EventManager();
		hudManager = new HudManager();
		discordRP.start();
		FontUtil.bootstrap();
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
