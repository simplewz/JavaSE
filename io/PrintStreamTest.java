package io;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
	
	public static void main(String[] args) {
		PrintStream ps=null;
		try {
			FileOutputStream fos=new FileOutputStream("./src/io/test.txt");
			ps=new PrintStream(fos);
			ps.println("ÆÕÍ¨×Ö·û´®");
			ps.println(new PrintStreamTest());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				ps.close();
			}
		}
	}
}
