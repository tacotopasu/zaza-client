package mint.modules.movement;

import org.lwjgl.input.Keyboard;

import mint.events.Event;
import mint.events.listeners.EventUpdate;
import mint.modules.Module;
public class Fly extends Module{

	public Fly() {
		super("Fly", Keyboard.KEY_G, Category.MOVEMENT);
	}
	
	public void onEnable() {
		System.out.println(this.name + " module enabled!");
	}
	
	public void onDisable() {
		mc.player.capabilities.isFlying = false;
		System.out.println(this.name + " module disabled!");
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.player.capabilities.isFlying = true;
			}
		}
	}
}
