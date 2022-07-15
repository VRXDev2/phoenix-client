package phoenixclient;

import phoenixclient.gui.SplashScreen;

public class Client {

	public String name = "Phoenix Client";
	public String version = "1.0.0";
	public String author = "VRXDev, asem__1425";
	
	public static Client INSTANCE = new Client();
	
	public DiscordRP discordRP = new DiscordRP();
	
	public void startup() {
		discordRP.start();
		//SplashScreen.setProgress(1, "Discord RPC");
		System.out.println("Starting " + name + " " + version);
	}
	
	public void shutdown() {
		discordRP.shutdown();
		System.out.println("Stopping " + name + " " + version);
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
}
