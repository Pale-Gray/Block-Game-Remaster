package me.pale.utils;

public class MathUtils {

	static float t = 0;
	
	public static float lerp(float p1, float p2, float speed) {
		
		t += speed;
		
		if (t > 1) {
			
			return p2;
			
		}
		
		return (p1 + (p2 - p1) * t);
		
	}
	
	public static float cubicLerp(float p1, float p2, float speed) {
		
		t += speed;
		
		float speed2 = (float) ((1 - Math.cos(t * Math.PI)) / 2);
		
		if (t > 1) {
			
			return p2;
			
		}
		
		return (p1 * (1 - speed2) + p2 * speed2);
		
	}
	
}
