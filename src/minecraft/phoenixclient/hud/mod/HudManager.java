package phoenixclient.hud.mod;

import java.util.ArrayList;

import phoenixclient.hud.mod.impl.FPSMod;
import phoenixclient.hud.mod.impl.Keystrokes;
import phoenixclient.hud.mod.impl.PingMod;
import phoenixclient.hud.mod.impl.TargetHUD;
import phoenixclient.hud.mod.impl.TestMod;


public class HudManager {

	
	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public TestMod tsetMod;
	public FPSMod fps;
	public TargetHUD targetHud;
	public Keystrokes keystrokes;
//	public PingMod pingMod;
	
	public HudManager() {

		hudMods.add(tsetMod = new TestMod());
		hudMods.add(fps = new FPSMod());
		hudMods.add(targetHud = new TargetHUD());
		hudMods.add(keystrokes = new Keystrokes());
//		hudMods.add(pingMod = new PingMod());
		
	}
	
	public void renderMods() {
		for (HudMod m : hudMods) {
			if (m.isEnabled()) {
				m.draw();
			}
		}
	}
	
}
