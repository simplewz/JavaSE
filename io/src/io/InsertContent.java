package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {

	public static void insertContent(String fileName,long pos,String content) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(fileName, "rw");
		File temp=File.createTempFile("temp", null);
		FileInputStream tempIn=new FileInputStream(temp);
		FileOutputStream tempOut=new FileOutputStream(temp);
		temp.delete();
		
		int hasRead=0;
		byte[] buff=new byte[1024];
		raf.seek(pos);
		while((hasRead=raf.read(buff))>0) {
			tempOut.write(buff, 0, hasRead);
		}
		tempOut.close();
		
		raf.seek(pos);
		raf.write(content.getBytes());
		while((hasRead=tempIn.read(buff))>0) {
			raf.write(buff);
		}
		tempIn.close();
		raf.close();
	}
	
	public static void main(String[] args) throws IOException{
		insertContent("./src/io/InsertContent.java",200,"/*Ìí¼Ó×¢ÊÍÄÚÈİ*/\r\n");
	}

}
