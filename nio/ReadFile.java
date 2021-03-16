package nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {

	public static void main(String[] args) {
		FileChannel fileChannel=null;
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("./src/nio/ReadFile.java");
			fileChannel=fis.getChannel();
			ByteBuffer buff=ByteBuffer.allocate(1024);
			while(fileChannel.read(buff)!=-1) {
				buff.flip();
				Charset charset=Charset.forName("gb2312");
				CharsetDecoder decoder=charset.newDecoder();
				CharBuffer cbuff=decoder.decode(buff);
				System.out.println(cbuff);
				buff.clear();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fileChannel!=null) {
					fileChannel.close();
				}
				if(fis!=null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
