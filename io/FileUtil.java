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
	
    /**
     * 为指定目录下的所有子目录加上统一前缀
     * @param parentDirPath   指定目录
     * @param prefix          需要添加的前缀
     */
    public static void plusPrefix(String parentDirPath,String prefix){
        File parentDir = new File(parentDirPath);
        if(!parentDir.exists()){
            System.out.println("指定父目录不存在！");
            return;
        }
        if(!parentDir.isDirectory()){
           System.out.println("指定的文件不是目录！");
           return;
        }
        File[] childDirList = parentDir.listFiles(
                new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        return file.isDirectory();
                    }
                }
        );

        if(Objects.nonNull(childDirList)&&childDirList.length>0){
            for(File childDir:childDirList){
                String childDirName = childDir.getName();
                String formatDirName = prefix+childDirName;
                childDir.renameTo(new File(childDir.getParent()+File.separator+formatDirName));
            }
        }
    }
}
