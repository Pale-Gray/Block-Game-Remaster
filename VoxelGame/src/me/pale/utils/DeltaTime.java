package me.pale.utils;

import org.lwjgl.Sys;

public class DeltaTime {
	
	static long lastTime;
	static int  delta;
	
	private static long getTime() {
		
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
		
	}
	
	private static int getDelta() {
		
		long currentTime = getTime();
		delta = (int) (currentTime - lastTime);
		lastTime = currentTime;
		return delta;
		
	}
	
	public static int getDeltaTime() {
		
		return getDelta();
		
	}

}
