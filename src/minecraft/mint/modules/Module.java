package mint.modules;

import mint.events.Event;
import net.minecraft.client.Minecraft;

public class Module {

	public String name;
	public Category category;
	public boolean toggled;
	public int keyCode;
	public Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name, int key, Category c) {
		this.name = name;
		this.keyCode = key;
		this.category = c;
	}
	
	public boolean isEnabled() { return toggled; }
	public int getKey() { return keyCode; }
	
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	
	public void onEvent(Event e) {
		
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public enum Category{
		COMBAT("Combat"),
		MOVEMENT("Movement"),
		PLAYER("Player"),
		RENDER("Render");
		
		public String name;
		
		Category(String name){
			this.name = name;
		}
	}
	
}
