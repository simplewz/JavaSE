package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		try(
				FileWriter writer=new FileWriter("./src/io/poem.txt");
			)
		{
			writer.write("这是一首诗");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
