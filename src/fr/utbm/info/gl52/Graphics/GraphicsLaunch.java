package fr.utbm.info.gl52.Graphics;


import java.io.IOException;

import fr.utbm.info.gl52.Graphics.Frame.Window;

public class GraphicsLaunch {

	public static void main(String[] args) throws IOException {
		Window w = new Window("Test", 600,600);
		w.setVisible(true);
	}
}
