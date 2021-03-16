package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		try(
			FileInputStream fis=new FileInputStream("./src/io/FileOutputStreamTest.java");
			FileOutputStream fos=new FileOutputStream("./src/io/a.txt")
			)
		{
			byte[] buff=new byte[32];
			int hasRead=0;
			while((hasRead=fis.read(buff))>0) {
				fos.write(buff, 0, hasRead);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
