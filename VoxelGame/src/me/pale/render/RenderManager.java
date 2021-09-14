package me.pale.render;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import me.pale.player.Player;
import me.pale.voxel.Chunk;
import me.pale.voxel.GrassVoxel;
import me.pale.voxel.Skybox;

public class RenderManager {
	
	static GrassVoxel g = new GrassVoxel();
	static Chunk c = new Chunk();
	static Skybox skybox = new Skybox();

	public static void initialize() {
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(0.0f, 0.0f, 0.1f, 1.0f);
		
		//Rendering goes here.
		// System.out.println(DeltaTime.DELTA_TIME);
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			
			Display.destroy();
			System.exit(0);
			
		}
		
		Player.doPlayerMovement();
		
		GL11.glPushMatrix();
		
		GL11.glRotatef(Player.getRx(), -1, 0, 0);
		GL11.glRotatef(Player.getRy(), 0, 1, 0);
		
		GL11.glTranslatef(Player.getX(), Player.getY(), Player.getZ());
		
		// g.draw();
		c.draw();
		
		// skybox.draw();
		
		GL11.glPopMatrix();
		
		// GL11.glPopMatrix();
		
	}
	
}
