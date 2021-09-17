package me.pale.voxel;

import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

import me.pale.render.ShaderList;

public class GrassVoxel extends BaseVoxel {
	
	float a = 0;
	float t = 0;
	
	VoxelTexture vt = new VoxelTexture("./res/images/grassblock.png");

	@Override
	public BaseVoxel draw() {
		
		t += 0.0001f;
		
		if (t > 2 * Math.PI) {
			
			t = 0;
			
		}
		
		ShaderList.BASIC_SHADER.use();
		
		ShaderList.BASIC_SHADER.setUniformf("t", t);
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef(x, y, z-3);
		
		// GL11.glRotatef(a+=0.1f, 1, 1, 0);
		
		// ShaderList.BASIC_SHADER.use();
		
		vt.bind();
		
		GL11.glBegin(GL11.GL_TRIANGLES);
		//GL11.glColor3f(1, 0, 0);
		//front
		GL11.glNormal3f(0.0f, 0.0f, 1.0f);
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
		GL11.glNormal3f(-1.0f, 0.0f, 0.0f);
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
		GL11.glNormal3f(0.0f, 0.0f, -1.0f);
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
		GL11.glNormal3f(1.0f, 0.0f, 0.0f);
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
		GL11.glNormal3f(0.0f, 1.0f, 0.0f);
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
		GL11.glNormal3f(0.0f, -1.0f, 0.0f);
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
		
		GL11.glPopMatrix();
		
		vt.unbind();
		
		ShaderList.BASIC_SHADER.unuse();
		
		return this;
		
	}

}
