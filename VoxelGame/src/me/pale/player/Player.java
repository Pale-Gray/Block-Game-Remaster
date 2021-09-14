package me.pale.player;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Player {
	
	public static float FOV = 90.0f;
	
	private static float x, y, z, rx, ry, rz = 0;
	
	private static float speed = 0.01f;
	private static float sens = 0.5f;
	
	public static void doPlayerMovement() {
		
		ry += Mouse.getDX() * sens;
		rx += Mouse.getDY() * sens;
		
		if (ry > 360) {
			
			ry = 0;
			
		}
		if (ry < 0) {
			
			ry = 360;
			
		}
		if (rx > 90) {
			
			rx = 90;
			
		}
		if (rx < -90) {
			
			rx = -90;
			
		}
		
		
		float sinx = (float) Math.sin(Math.toRadians(ry)) * (speed);
		float cosz = (float) Math.cos(Math.toRadians(ry)) * (speed);
		
		// System.out.println(sinx + ", " + cosz);
		
		// System.out.println("ryc: " + Math.cos(ry) + ", rxs: " + Math.sin(rx));
		
		Player.FOV += Mouse.getDWheel();
		
		if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
			
			speed = 0.02f;
			
		} else {
			
			speed = 0.01f;
			
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			
			y -= speed;
			
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			
			y += speed;
			
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			
			//z += (speed);
			// x -= (Math.cos(rx)) / 16;
			// z += cosz;
			z += cosz;
			x -= sinx;
			
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			
			z -= cosz;
			x += sinx;
			
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			
			z += sinx;
			x += cosz;
			
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			
			z -= sinx;
			x -= cosz;
			
		}
		
	}

	public static float getX() {
		return x;
	}

	public static float getY() {
		return y;
	}

	public static float getZ() {
		return z;
	}

	public static float getRx() {
		return rx;
	}

	public static float getRy() {
		return ry;
	}

	public static float getRz() {
		return rz;
	}

}
