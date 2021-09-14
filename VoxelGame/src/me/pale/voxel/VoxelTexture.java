package me.pale.voxel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class VoxelTexture implements Texture {
	
	Texture t;
	
	public VoxelTexture(String res) { 
		
		try {
			t = TextureLoader.getTexture("PNG",	new FileInputStream(new File(res)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void bind() {
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, t.getTextureID());
	}
	
	public void unbind() {
		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getImageHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getImageWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] getTextureData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTextureHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTextureID() {
		return t.getTextureID();
	}

	@Override
	public String getTextureRef() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTextureWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasAlpha() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void release() {
		t.release();
	}

	@Override
	public void setTextureFilter(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
