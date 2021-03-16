package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadDataFromProcess {
	
	public static void main(String[] args) {
		BufferedReader br=null;
		try {
			Process javacP=Runtime.getRuntime().exec("javac");
			br=new BufferedReader(new InputStreamReader(javacP.getErrorStream()));
			String buff=null;
			while((buff=br.readLine())!=null) {
				System.out.println(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
