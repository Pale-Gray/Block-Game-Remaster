package me.pale.player;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import me.pale.utils.DeltaTime;

public class Player {
	
	public static float FOV = 90.0f;
	
	private static float x, y, z, rx, ry, rz = 0;
	
	private static float speed = 0.005f;
	private static float sens = 0.5f;
	
	public static void doPlayerMovement() {
		
		float delta = DeltaTime.getDeltaTime();
		
		ry += (Mouse.getDX() * sens);
		rx += (Mouse.getDY() * sens);
		
		if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
			
			speed = 0.01f;
			
		} else {
			
			speed = 0.005f;
			
		}
		
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
		
		// System.out.println(delta);
		
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			
			y -= speed * delta;
			
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			
			y += speed * delta;
			
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			
			//z += (speed);
			// x -= (Math.cos(rx)) / 16;
			// z += cosz;
			
			z += cosz * delta;
			x -= sinx * delta;
			
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			
			z -= cosz * delta;
			x += sinx * delta;
			
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			
			z += sinx * delta;
			x += cosz * delta;
			
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			
			z -= sinx * delta;
			x -= cosz * delta;
			
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
