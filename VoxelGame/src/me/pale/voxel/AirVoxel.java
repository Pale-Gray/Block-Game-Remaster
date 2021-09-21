package me.pale.voxel;

public class AirVoxel extends BaseVoxel {

	public static final int ID = 0;
	
	@Override
	public BaseVoxel draw() {
		
		return this;
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
