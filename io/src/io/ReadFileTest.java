package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class ReadFileTest {
	
	public static void main(String[] args) throws IOException {
		//File file=new File("C:\\Users\\admin\\Desktop\\yc\\服务器信息.txt");
		InputStream in=new FileInputStream("C:\\Users\\admin\\Desktop\\yc\\服务器信息.txt");
		byte[] buff=new byte[10];
		while(in.read(buff)!=-1) {
			/*
			for(int i=0;i<buff.length;i++) {
				if(i!=buff.length-1) {
					System.out.print(buff[i]+" ");
				}else {
					System.out.print(buff[i]+"\r\n");
				}
			}*/
			System.out.println(new String(buff));
		}
		in.close();
		
		System.out.println("=========================");
		
		Reader reader=new FileReader("C:\\Users\\admin\\Desktop\\yc\\服务器信息.txt");
		BufferedReader bf=new BufferedReader(reader);
		// char[] cBuff=new char[20];
		String s=null;
		while(/*reader.read(cBuff)!=-1*/(s=bf.readLine())!=null) {
			/*
			for(int i=0;i<cBuff.length;i++) {
				if(i!=cBuff.length-1) {
					System.out.print(cBuff[i]+" ");
				}else {
					System.out.print(cBuff[i]+"\r\n");
				}
			}
			System.out.println(new String(cBuff));
			*/
			System.out.println(s);
		}
		reader.close();
		/*
		OutputStream out=new FileOutputStream("C:\\Users\\admin\\Desktop\\yc\\服务器信息.txt");
		out.close();
		*/
	}	
}
