package me.pale.voxel;

public class Chunk {
	
	public Chunk() {} 
	
	private static final int CHUNK_DIMENSION = 5;
	
	private int x, y, z = 0;
	
	public void draw() {
		
		for (int cx = 0; cx < CHUNK_DIMENSION; cx++) {
			
			for (int cy = 0; cy < CHUNK_DIMENSION; cy++) {
				
				for (int cz = 0; cz < CHUNK_DIMENSION; cz++) {
					
					VoxelList.GRASS_VOXEL.setX(cx).setY(cy).setZ(cz).draw();
					
				}
				
			}
			
		}
		
	}
	

}
