package me.pale.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.LWJGLException;

import me.pale.utils.LWJGLNativeManager;
import me.pale.utils.WindowManager;

public class VoxelGame {
	
	public static void main(String[] args) throws LWJGLException, FileNotFoundException {
		
		LWJGLNativeManager.autoSetLibraryPath();
		WindowManager.makeWindow(); 
		
	}

}
