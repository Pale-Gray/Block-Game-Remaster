package me.pale.render;

import org.lwjgl.Sys;

public class ShaderList {
	
	public static final Shader BASIC_SHADER = new Shader("./res/shaders/basicVertex.txt", "./res/shaders/basicFragment.txt");

	public static void destroyShaders() {
		
		BASIC_SHADER.destroy();
		
	}
	
}
