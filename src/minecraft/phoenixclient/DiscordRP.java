package phoenixclient;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class DiscordRP {

	private boolean running = true;
	private long created = 0;
	
	public void start() {
		
		this.created = System.currentTimeMillis();
		
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			@Override
			public void apply(DiscordUser user) {
				
				System.out.println("Welcome " + user.username + "#" + user.discriminator);
				update("Idle", "Main Menu");
			}
		}).build();
		
		DiscordRPC.discordInitialize("997080237630291978", handlers, running);
		
		new Thread("Discord RPC Callback") {
			public void run() {
				while(running) {
					DiscordRPC.discordRunCallbacks();
				}
			};
		}.start();
	}
	
	public void shutdown() {
		DiscordRPC.discordShutdown();
		running = false;
	}
	
	public void update(String firstLine, String secondLine) {
		
		DiscordRichPresence.Builder b= new DiscordRichPresence.Builder(secondLine);
		b.setBigImage("pci", "");
		b.setDetails(firstLine);
		//b.setEndTimestamp(created);
		b.setStartTimestamps(created);
		
		DiscordRPC.discordUpdatePresence(b.build());
	}
	
}
