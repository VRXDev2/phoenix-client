package phoenixclient.mods;

import phoenixclient.gui.hud.HUDManager;
import phoenixclient.mods.impl.TestMod;

public class ModInstances {
	
	static TestMod testMod;
	
	
	public static void register(HUDManager manager) {
		testMod = new TestMod();
		manager.register(testMod);
	}
	
	public static TestMod getTestMod() {
		return testMod;
	}
	

}
