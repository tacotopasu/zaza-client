package mint.modules.player;

import org.lwjgl.input.Keyboard;

import mint.events.Event;
import mint.events.listeners.EventUpdate;
import mint.modules.Module;
import net.minecraft.network.play.client.CPacketPlayer;

public class NoFall extends Module{

	public NoFall() {
		super("NoFall", Keyboard.KEY_K, Category.PLAYER);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.player.fallDistance > 2) {
					mc.player.connection.sendPacket(new CPacketPlayer(true));
					mc.player.fallDistance = (float) Math.random();
				}
				
			}
		}
	}
	
}
