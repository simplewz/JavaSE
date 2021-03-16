package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
	
	/**
	 * 将文件或目录复制到指定文件夹下
	 * @param src        源文件路径
	 * @param dest       目标文件路径
	 * @throws IOException
	 */
	public static void copy(String src,String dest) throws IOException {
		File srcFile=Paths.get(src).toFile();
		if(!srcFile.exists()) {
			throw new IOException("Source File: "+src+" doesn't exists!");
		}
		
		if(srcFile.isFile()) {
			File destFile=Paths.get(dest).toFile();
			if(destFile.isFile()) {
				Files.copy(Paths.get(src), Paths.get(dest));
			}else {
				Files.createDirectories(Paths.get(dest));
				String destFileName=dest+File.separator+srcFile.getName();
				Files.copy(Paths.get(src), Paths.get(destFileName));
			}
		}else if(srcFile.isDirectory()){
			
			Files.createDirectories(Paths.get(dest));
			
			String dirName=srcFile.getName();
			String destName=dest+File.separator+dirName;
			
			Files.createDirectories(Paths.get(destName));
			
			File[] files=srcFile.listFiles();
			for(int i=0;i<files.length;i++) {
				if(files[i].isFile()) {
					//System.out.println(destName+File.separator+files[i].getName());
					File file=Paths.get(destName+File.separator+files[i].getName()).toFile();
					Files.copy(files[i].toPath(), file.toPath());
				}else {
					//System.out.println(files[i].getAbsolutePath());
					copy(files[i].getAbsolutePath(), destName);
				}
			}
		}	
	}
}
