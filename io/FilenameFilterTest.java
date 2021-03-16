package io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class FilenameFilterTest {
	
	public static void main(String[] args) throws IOException{
		File file=new File("./src/io");
		File[] javaFile=file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if(pathname.getName().endsWith(".java")) {
					return true;
				}
				return false;
			}
		});
		
		for(File cFile:javaFile) {
			System.out.println(cFile.getAbsolutePath());
		}
	}
	
}
