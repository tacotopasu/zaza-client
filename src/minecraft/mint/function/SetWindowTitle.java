package mint.function;

import org.lwjgl.opengl.Display;

public class SetWindowTitle {

	public SetWindowTitle(String title) {
		Display.setTitle(title);
	}
}
