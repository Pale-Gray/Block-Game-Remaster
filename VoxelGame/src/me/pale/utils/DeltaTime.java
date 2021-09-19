package me.pale.utils;

import org.lwjgl.Sys;

public class DeltaTime {
	
	static long lastTime;
	static long delta;
	
	private static long getTime() {
		
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
		
	}
	
	private static float getDelta() {
		
		long currentTime = getTime();
		delta = (currentTime - lastTime);
		lastTime = currentTime;
		return delta;
		
	}
	
	public static float getDeltaTime() {
		
		return getDelta();
		
	}

}
