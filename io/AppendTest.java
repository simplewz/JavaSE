package io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendTest {
	
	public static void main(String[] args) {
		RandomAccessFile raf=null;
		try {
			raf=new RandomAccessFile("./src/io/out.txt", "rw");
			raf.seek(raf.length());
			raf.write("文件末尾追加内容".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(raf!=null) {
					raf.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
