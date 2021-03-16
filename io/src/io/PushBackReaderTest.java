package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushBackReaderTest {

	public static void main(String[] args) {
		PushbackReader pr=null;
		try {
			pr=new PushbackReader(new FileReader("./src/io/PushBackReaderTest.java"),500);
			char[] cbuf=new char[80];
			String lastContent="";
			int hasRead=0;
			while((hasRead=pr.read(cbuf))>0) {
				String content=new String(cbuf,0,hasRead);
				int targetIndex=0;
				if((targetIndex=(lastContent+content).indexOf("new PushbackReader"))>0) {
					pr.unread((lastContent+content).toCharArray());
					pr.read(cbuf,0,targetIndex);
					System.out.println(new String(cbuf,0,targetIndex));
					System.exit(0);
				}else {
					System.out.println(lastContent);
					lastContent=content;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}

}
