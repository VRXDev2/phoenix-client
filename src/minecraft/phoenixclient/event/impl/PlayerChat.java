package phoenixclient.event.impl;

import phoenixclient.event.Event;

public class PlayerChat extends Event{
	String msg;
	
	public PlayerChat(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
	public void setCanceled(boolean canceled) {
		this.setCancelled(canceled);
	}
	

}
