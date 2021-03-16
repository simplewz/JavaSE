package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyInTest {

	public static void main(String[] args){
		BufferedReader br=null;
		try {
			InputStreamReader isr=new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			String buff=null;
			while((buff=br.readLine())!=null) {
				if(buff.equalsIgnoreCase("exit")) {
					System.exit(0);
				}else {
					System.out.println(" ‰»Îƒ⁄»›£∫"+buff);
				}
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
