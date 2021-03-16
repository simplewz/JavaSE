package nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {

	public static void main(String[] args) {
		FileChannel randomFileChannel=null;
		try {
			File file=new File("./src/nio/out.txt");
			RandomAccessFile raf=new RandomAccessFile(file, "rw");
			randomFileChannel=raf.getChannel();
			ByteBuffer buffer=randomFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, raf.length());
			randomFileChannel.position(file.length());
			randomFileChannel.write(buffer);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(randomFileChannel!=null) {
					randomFileChannel.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
