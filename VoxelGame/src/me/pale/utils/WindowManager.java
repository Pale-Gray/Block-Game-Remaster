package me.pale.utils;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13;
import org.lwjgl.util.glu.GLU;

import me.pale.player.Player;
import me.pale.render.RenderManager;
import me.pale.render.ShaderList;

public class WindowManager {
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;

	private static void update() {
		
		while (!Display.isCloseRequested()) {
			
			Display.setTitle("FPS: " + (Sys.getTimerResolution()));
			RenderManager.initialize();
			
			Display.update();
			
		}
		Display.destroy();
		ShaderList.destroyShaders();
		System.exit(0);
		
	}
	
	public static void makeWindow() throws LWJGLException {
		
		Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
		Display.setTitle("Game");
		Display.setResizable(false);
		Display.create();
		
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glFrontFace(GL11.GL_CW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_CULL_FACE);
		
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		
		Mouse.setGrabbed(true);
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glClearColor(0, 0, 0, 0);
		GLU.gluPerspective(Player.FOV, 1.333f, 0.1f, 650.0f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		update();
		
	}
	
}
