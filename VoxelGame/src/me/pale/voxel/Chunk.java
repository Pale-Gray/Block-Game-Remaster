package me.pale.voxel;

import java.util.Random;

import me.pale.utils.OpenSimplexNoise;

public class Chunk {
	
	public Chunk() {} 
	
	private boolean isGenerating = true;
	
	private static int CHUNK_DIMENSION = 16;

	private static int[][][] BLOCKTYPE = new int[CHUNK_DIMENSION][CHUNK_DIMENSION][CHUNK_DIMENSION];
	private static BaseVoxel[][][] VOXELS = new BaseVoxel[CHUNK_DIMENSION][CHUNK_DIMENSION][CHUNK_DIMENSION];
	
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
						
						float b = 8;
						float a = (float) osn.eval(ix/b, iy/b, iz/b) * 5;
						
						if (a > 1) {
							
							a = 1;
							
						} else {
							
							a = 0;
							
						}
						
						if (a == 1) {
							
							VOXELS[ix][iy][iz] = new GrassVoxel();
							System.out.println(VOXELS[ix][iy][iz]);
							
						} else {
							
							VOXELS[ix][iy][iz] = new AirVoxel();
							
						}
						
						//System.out.println(BLOCKTYPE[ix][iy][iz]);
						
					}
					
				}
				
			}
			
			for (int ix = 0; ix < CHUNK_DIMENSION; ix++) {
				
				for (int iy = 0; iy < CHUNK_DIMENSION; iy++) {
					
					for (int iz = 0; iz < CHUNK_DIMENSION; iz++) {
						
						/* if (iz > 2) {
							
							System.out.println(VOXELS[ix][iy][iz+1]);
							if (VOXELS[ix][iy][iz] == VoxelList.GRASS_VOXEL) {
								
								VOXELS[ix][iy][iz].setBack(false);
								
							}
							
						} */
						
						if (iy < CHUNK_DIMENSION - 1) {
							
							if (VOXELS[ix][iy][iz].getID() == VOXELS[ix][iy+1][iz].getID()) {
								
								VOXELS[ix][iy][iz].setTop(false);
								
							}
							
						}
						
						if (iy > CHUNK_DIMENSION - CHUNK_DIMENSION /* 0 */ ) {
							
							if (VOXELS[ix][iy][iz].getID() == VOXELS[ix][iy-1][iz].getID()) {
								
								VOXELS[ix][iy][iz].setBottom(false);
								
							}
							
						}
						
						if (ix < CHUNK_DIMENSION - 1) {
							
							if (VOXELS[ix][iy][iz].getID() == VOXELS[ix+1][iy][iz].getID()) {
								
								VOXELS[ix][iy][iz].setRight(false);
								
							}
							
						}
						
						if (ix > CHUNK_DIMENSION - CHUNK_DIMENSION /* 0 */ ) {
							
							if (VOXELS[ix][iy][iz].getID() == VOXELS[ix-1][iy][iz].getID()) {
								
								VOXELS[ix][iy][iz].setLeft(false);
								
							}
							
						}
						
						if (iz < CHUNK_DIMENSION - 1) {
							
							if (VOXELS[ix][iy][iz].getID() == VOXELS[ix][iy][iz+1].getID()) {
								
								VOXELS[ix][iy][iz].setFront(false);
								
							}
							
						}
						
						if (iz > CHUNK_DIMENSION - CHUNK_DIMENSION /* 0 */ ) {
							
							if (VOXELS[ix][iy][iz].getID() == VOXELS[ix][iy][iz-1].getID()) {
								
								VOXELS[ix][iy][iz].setBack(false);
								
							}
							
						}
						
						/* if (iy < CHUNK_DIMENSION - 1) {
							
							if (VOXELS[ix][iy][iz].getID() == VOXELS[ix][iy+1][iz].getID()) {
								
								VOXELS[ix][iy][iz].setTop(false);
								
							}
							
						} */
						
						/* if (iy < CHUNK_DIMENSION - 1) {
							
							if (VOXELS[ix][iy][iz].getID() == 1 && VOXELS[ix][iy+1][iz].getID() == 1) {
								
								VOXELS[ix][iy][iz].setTop(false);
								
							}
							
						}
						
						if (iy > 0) {
							
							if (VOXELS[ix][iy][iz].getID() == 1 && VOXELS[ix][iy-1][iz].getID() == 1) {
								
								VOXELS[ix][iy][iz].setBottom(false);
								
							}
							
						} */
						
					}
					
				}
				
			}
			
			isGenerating = false;
			
		}
		
		for (int cx = 0; cx < CHUNK_DIMENSION; cx++) {
			
			for (int cy = 0; cy < CHUNK_DIMENSION; cy++) {
				
				for (int cz = 0; cz < CHUNK_DIMENSION; cz++) {
					
					// System.out.println(BLOCKTYPE[cx][cy][cz]);
					float a = 15;
					t+= 0.00001f;
					
					// VOXELS[cx][cy][cz].setX(cx).setY((int) ( osn.eval((cx/a), (cz/a)) * (Math.sin(t*5) * 15) )  ).setZ(cz).draw();
					VOXELS[cx][cy][cz].setX(cx).setY(cy).setZ(cz).draw();
					// VoxelList.GRASS_VOXEL.setX(cx).setY( (int) (osn.eval(cx/a + t, cz/a + t) * 5 ) ).setZ(cz).draw();
					
				}
				
			}
			
		}
		
	}
	

}
