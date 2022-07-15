package phoenixclient;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

public class FeaturedServer extends ServerData {

	public static final ResourceLocation starIcon = new ResourceLocation("client/ui/star.png");
	
	public FeaturedServer(String serverName, String serverIP) {
		super(serverName, serverIP, false);
	}

}
