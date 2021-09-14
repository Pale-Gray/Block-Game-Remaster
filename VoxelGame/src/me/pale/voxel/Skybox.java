package me.pale.voxel;

import org.lwjgl.opengl.GL11;

import me.pale.player.Player;

public class Skybox {

	public Skybox() {}
	
	public void draw() {
		
		GL11.glPushMatrix();
		
		GL11.glFrontFace(GL11.GL_CCW);
		
		GL11.glBegin(GL11.GL_TRIANGLES);
		//GL11.glColor3f(1, 0, 0);
		//front
		GL11.glTexCoord2f(0.5f, 0.0f);
		GL11.glVertex3f(-0.5f, 0.5f, 0.5f);
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f(0.5f, 0.5f, 0.5f);
		GL11.glTexCoord2f(1.0f, 0.5f);
		GL11.glVertex3f(0.5f, -0.5f, 0.5f);
		GL11.glTexCoord2f(1.0f, 0.5f);
		GL11.glVertex3f(0.5f, -0.5f, 0.5f);
		GL11.glTexCoord2f(0.5f, 0.5f);
		GL11.glVertex3f(-0.5f, -0.5f, 0.5f);
		GL11.glTexCoord2f(0.5f, 0.0f);
		GL11.glVertex3f(-0.5f, 0.5f, 0.5f);
		
		//left
		GL11.glTexCoord2f(0.5f, 0.0f);
		GL11.glVertex3f(-0.5f, 0.5f, -0.5f);
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f(-0.5f, 0.5f, 0.5f);
		GL11.glTexCoord2f(1.0f, 0.5f);
		GL11.glVertex3f(-0.5f, -0.5f, 0.5f);
		GL11.glTexCoord2f(1.0f, 0.5f);
		GL11.glVertex3f(-0.5f, -0.5f, 0.5f);
		GL11.glTexCoord2f(0.5f, 0.5f);
		GL11.glVertex3f(-0.5f, -0.5f, -0.5f);
		GL11.glTexCoord2f(0.5f, 0.0f);
		GL11.glVertex3f(-0.5f, 0.5f, -0.5f);
		
		//back
		GL11.glTexCoord2f(0.5f, 0.0f);
		GL11.glVertex3f(0.5f, 0.5f, -0.5f);
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f(-0.5f, 0.5f, -0.5f);
		GL11.glTexCoord2f(1.0f, 0.5f);
		GL11.glVertex3f(-0.5f, -0.5f, -0.5f);
		GL11.glTexCoord2f(1.0f, 0.5f);
		GL11.glVertex3f(-0.5f, -0.5f, -0.5f);
		GL11.glTexCoord2f(0.5f, 0.5f);
		GL11.glVertex3f(0.5f, -0.5f, -0.5f);
		GL11.glTexCoord2f(0.5f, 0.0f);
		GL11.glVertex3f(0.5f, 0.5f, -0.5f);
		
		//right
		GL11.glTexCoord2f(0.5f, 0.0f);
		GL11.glVertex3f(0.5f, 0.5f, 0.5f);
		GL11.glTexCoord2f(1.0f, 0.0f);
		GL11.glVertex3f(0.5f, 0.5f, -0.5f);
		GL11.glTexCoord2f(1.0f, 0.5f);
		GL11.glVertex3f(0.5f, -0.5f, -0.5f);
		GL11.glTexCoord2f(1.0f, 0.5f);
		GL11.glVertex3f(0.5f, -0.5f, -0.5f);
		GL11.glTexCoord2f(0.5f, 0.5f);
		GL11.glVertex3f(0.5f, -0.5f, 0.5f);
		GL11.glTexCoord2f(0.5f, 0.0f);
		GL11.glVertex3f(0.5f, 0.5f, 0.5f);
		
		//top
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glVertex3f(-0.5f, 0.5f, -0.5f);
		GL11.glTexCoord2f(0.5f, 0.0f);
		GL11.glVertex3f(0.5f, 0.5f, -0.5f);
		GL11.glTexCoord2f(0.5f, 0.5f);
		GL11.glVertex3f(0.5f, 0.5f, 0.5f);
		GL11.glTexCoord2f(0.5f, 0.5f);
		GL11.glVertex3f(0.5f, 0.5f, 0.5f);
		GL11.glTexCoord2f(0.0f, 0.5f);
		GL11.glVertex3f(-0.5f, 0.5f, 0.5f);
		GL11.glTexCoord2f(0.0f, 0.0f);
		GL11.glVertex3f(-0.5f, 0.5f, -0.5f);
		
		//bottom
		GL11.glTexCoord2f(0.0f, 0.5f);
		GL11.glVertex3f(-0.5f, -0.5f, 0.5f);
		GL11.glTexCoord2f(0.5f, 0.5f);
		GL11.glVertex3f(0.5f, -0.5f, 0.5f);
		GL11.glTexCoord2f(0.5f, 1.0f);
		GL11.glVertex3f(0.5f, -0.5f, -0.5f);
		GL11.glTexCoord2f(0.5f, 1.0f);
		GL11.glVertex3f(0.5f, -0.5f, -0.5f);
		GL11.glTexCoord2f(0.0f, 1.0f);
		GL11.glVertex3f(-0.5f, -0.5f, -0.5f);
		GL11.glTexCoord2f(0.0f, 0.5f);
		GL11.glVertex3f(-0.5f, -0.5f, 0.5f);
		
		GL11.glEnd();
		
		GL11.glFrontFace(GL11.GL_CW);
		
		GL11.glPopMatrix();
		
	}
	
}
