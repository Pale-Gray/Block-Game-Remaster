package me.pale.voxel;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Chunk {
	
	public Chunk() {} 
	
	private Random r = new Random();
	
	private boolean isGenerating = true;
	
	private static int CHUNK_DIMENSION = 4;
	
	private static final int CHUNK_X = 4;
	private static final int CHUNK_Y = 4;
	private static final int CHUNK_Z = 4;
	
	int i, m, b = 0;
	
	private int x, y, z = 0;
	
	private float a = 0;
	private float cvb;
	
	ArrayList<Integer> CHUNK_Ys = new ArrayList<Integer>();
	
	public void draw() {
		
		// System.out.println(Mouse.getDX());
		
		if (Keyboard.next()) {
		
			if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
				
				CHUNK_DIMENSION++;
				
			} else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
				
				CHUNK_DIMENSION--;
				
			}
			
		}
		
		for (int cx = 0; cx < CHUNK_DIMENSION; cx++) {
			
			for (int cy = 0; cy < 1; cy++) {
				
				for (int cz = 0; cz < CHUNK_DIMENSION; cz++) {
					
					y = cz + cx;
					float a = 0.8f;
					float b = 0.8f;
					VoxelList.GRASS_VOXEL.setX(cx).setY(cy).setZ(cz).draw();
					// System.out.println(cx + ", " + cy + ", " + cz);
					
				}
				
			}
			
		}
		
	}
	

}
