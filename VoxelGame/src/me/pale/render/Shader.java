package me.pale.render;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.lwjgl.opengl.GL20;

public class Shader {
	
	int vertexShd;
	int fragmentShd;
	
	int fs;
	int vs;
	
	int shaderPrg;
	
	File vertexFile;
	File fragmentFile;
	
	String[] vertArray;
	String[] fragArray;
	
	ArrayList<String> vertexArray = new ArrayList<String>();
	ArrayList<String> fragmentArray = new ArrayList<String>();
		
	Scanner vertexScanner;
	Scanner fragmentScanner;
	
	public Shader(String vertexSRC, String fragmentSRC) {
		
		vertexFile = new File(vertexSRC);
		fragmentFile = new File(fragmentSRC);
		
		try {
			
			vertexScanner = new Scanner(vertexFile);
			fragmentScanner = new Scanner(fragmentFile);
			
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		while (vertexScanner.hasNextLine()) {
			
			vs++;
			
			// vertArray[vs] = vertexScanner.nextLine();
			
			vertexArray.add(vertexScanner.nextLine()+"\n");
			
		}
		
		while (fragmentScanner.hasNextLine()) {
			
			fs++;
			
			// fragArray[fs] = fragmentScanner.nextLine();
			
			fragmentArray.add(fragmentScanner.nextLine()+"\n");
			
		}
		
		// vertArray = vertexArray.toArray(new String[] {});
		// System.out.println(vertArray[0]);
		
		vertexShd = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
		// CharSequence[] csv = (CharSequence[]) vertexArray.toArray();
		GL20.glShaderSource(vertexShd, vertexArray.toArray(new String[] {}));
		GL20.glCompileShader(vertexShd);
		
		int isVertCompiled = GL20.glGetShaderi(vertexShd, GL20.GL_COMPILE_STATUS);
		
		if (isVertCompiled == 0) {
			
			String log = GL20.glGetShaderInfoLog(vertexShd, 512);
			System.out.println(log);
			
		}
		
		fragmentShd = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
		GL20.glShaderSource(fragmentShd, fragmentArray.toArray(new String[] {}));
		GL20.glCompileShader(fragmentShd);
		
		int isFragCompiled = GL20.glGetShaderi(fragmentShd, GL20.GL_COMPILE_STATUS);
		
		if (isFragCompiled == 0) {
			
			String log = GL20.glGetShaderInfoLog(fragmentShd, 512);
			System.out.println(log);
			
		}
		
		shaderPrg = GL20.glCreateProgram();
		GL20.glAttachShader(shaderPrg, vertexShd);
		GL20.glAttachShader(shaderPrg, fragmentShd);
		GL20.glLinkProgram(shaderPrg);
		
		int isShdCompiled = GL20.glGetShaderi(shaderPrg, GL20.GL_COMPILE_STATUS);
		
		if (isShdCompiled == 0) {
			
			String log = GL20.glGetProgramInfoLog(shaderPrg, 512);
			System.out.println(log);
			
		}
		
		GL20.glDeleteShader(vertexShd);
		GL20.glDeleteShader(fragmentShd);
		
	}
	
	public Shader use() {
		
		GL20.glUseProgram(shaderPrg);
		return this;
		
	}
	
	public Shader unuse() {
		
		GL20.glUseProgram(0);
		return this;
		
	}

}
