package me.pale.voxel;

import java.util.Random;

public class Chunk {
	
	public Chunk() {} 
	
	private boolean isGenerating = true;
	
	private static int CHUNK_DIMENSION = 16;

	private static int[][][] BLOCKTYPE = new int[CHUNK_DIMENSION][CHUNK_DIMENSION][CHUNK_DIMENSION];
	
	int t = 0;
	
	private int x, y, z = 0;
	
	private Random r = new Random();
	
	public void draw() {
		
		if (isGenerating == true) {
			
			for (int ix = 0; ix < CHUNK_DIMENSION; ix++) {
				
				for (int iy = 0; iy < CHUNK_DIMENSION; iy++) {
					
					for (int iz = 0; iz < CHUNK_DIMENSION; iz++) {
						
						int a = 2;
						
						BLOCKTYPE[ix][iy][iz] = r.nextInt(a);
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
						
						t += 0.1f;
				
						VoxelList.GRASS_VOXEL.setX(cx).setY( (int) (Math.sin((cx+cz) / 3) * 2 )).setZ(cz).draw();
						
					}
					
				}
				
			}
			
		}
		
	}
	

}
