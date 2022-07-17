package phoenixclient.mods;

import phoenixclient.gui.hud.HUDManager;
import phoenixclient.mods.impl.ModArmorStatus;
import phoenixclient.mods.impl.TestMod;

public class ModInstances {
	
	private static TestMod testMod;
	
	private static ModArmorStatus modArmorStatus;
	
	public static void register(HUDManager manager) {
		testMod = new TestMod();
		manager.register(testMod);
		
		modArmorStatus = new ModArmorStatus();
		manager.register(modArmorStatus);
	}
	
	public static TestMod getTestMod() {
		return testMod;
	}
	
	public static ModArmorStatus getArmorStatus() {
		return modArmorStatus;
	}

}
