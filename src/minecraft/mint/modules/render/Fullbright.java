package mint.modules.render;

import org.lwjgl.input.Keyboard;

import mint.events.Event;
import mint.events.listeners.EventUpdate;
import mint.modules.Module;
public class Fullbright extends Module{

	public Fullbright() {
		super("Fullbright", Keyboard.KEY_O, Category.RENDER);
	}
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 100;
		System.out.println(this.name + " module enabled!");
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1;
		System.out.println(this.name + " module disabled!");
	}
	
	
}
