package io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	
	public static void main(String[] args) {
		try(
				FileReader reader = new FileReader("./src/io/FileReaderTest.java");
				)
		{
			char[] cbuf=new char[400];
			int hasRead=0;
			while((hasRead=reader.read(cbuf))>0) {
				System.out.println(new String(cbuf,0,hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
