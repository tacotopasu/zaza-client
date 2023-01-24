package mint;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import mint.events.Event;
import mint.modules.Module;
import mint.modules.Module.Category;
import mint.modules.movement.*;
import mint.modules.player.*;
import mint.modules.render.*;
import mint.ui.HUD;

public class Client {

	public static String name = "Mint", version = "0.1a";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	public static HUD hud = new HUD();

	public static void startup() {
		System.out.println("Starting " + name + " Client v" + version);
		Display.setTitle(name + " v" + version);

		modules.add(new Fly());
		modules.add(new Sprint());
		modules.add(new Fullbright());
		modules.add(new NoFall());
	}
	

	public static void onEvent(Event e) {
		for (Module m : modules) {
			if (!m.toggled)
				continue;
			m.onEvent(e);

		}
	}

	public static void keyPress(int key) {
		for (Module m : modules) {
			if (m.getKey() == key) {
				m.toggle();
			}
		}
	}
	
	public List<Module> getModulesByCategory(Category c){
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : this.modules) {
			if(m.category == c) modules.add(m);
		}
		return modules;
	}
}
