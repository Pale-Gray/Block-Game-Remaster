package me.pale.voxel;

import java.util.Random;

import me.pale.utils.OpenSimplexNoise;

public class Chunk {
	
	public Chunk() {} 
	
	private boolean isGenerating = true;
	
	private static int CHUNK_DIMENSION = 16;

	private static int[][][] BLOCKTYPE = new int[CHUNK_DIMENSION][CHUNK_DIMENSION][CHUNK_DIMENSION];
	
	float t = 0;
	float a = 0;
	
	private int x, y, z = 0;
	
	private Random r = new Random();
	
	private OpenSimplexNoise osn = new OpenSimplexNoise();
	
	public void draw() {
		
		if (isGenerating == true) {
			
			for (int ix = 0; ix < CHUNK_DIMENSION; ix++) {
				
				for (int iy = 0; iy < CHUNK_DIMENSION; iy++) {
					
					for (int iz = 0; iz < CHUNK_DIMENSION; iz++) {
						
						int a = 2;
						
						BLOCKTYPE[ix][iy][iz] = r.nextInt(2);
						//System.out.println(BLOCKTYPE[ix][iy][iz]);
						
					}
					
				}
				
			}
			
			isGenerating = false;
			
		}
		
		for (int cx = 0; cx < CHUNK_DIMENSION; cx++) {
			
			for (int cy = 0; cy < CHUNK_DIMENSION; cy++) {
				
				for (int cz = 0; cz < CHUNK_DIMENSION; cz++) {
					
					// System.out.println(BLOCKTYPE[cx][cy][cz]);
					
					if (BLOCKTYPE[cx][cy][cz] != 0 ) {
						
						// float a = 15f;
						t+=0.00001f;
						a += 0.0001f;
				
						VoxelList.GRASS_VOXEL.setX(cx).setY( (int) (osn.eval((cx/a), (cz/a) + t) * Math.sin(a) * 5)   ).setZ(cz).draw();
						
					}
					
				}
				
			}
			
		}
		
	}
	

}
