package io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) {
		RandomAccessFile raf=null;
		try {
			raf=new RandomAccessFile(new File("./src/io/out.txt"), "r");
			long pointer=raf.getFilePointer();
			System.out.println("pointer:"+pointer);
			raf.seek(20);
			byte[] buff=new byte[1024];
			int hasRead=0;
			while((hasRead=raf.read(buff))>0) {
				System.out.println(new String(buff, 0, hasRead));
			}
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
