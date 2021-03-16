package io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	
	public static void main(String[] args){
		try(
			FileInputStream inputStream=new FileInputStream("./src/io/FileInputStreamTest.java");
		   )
		{
			byte[] buff=new byte[1024];
			int hasRead=0;
			while((hasRead=inputStream.read(buff))>0) {
				System.out.println(new String(buff, 0, hasRead));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
