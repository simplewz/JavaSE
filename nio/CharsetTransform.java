package nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {

	public static void main(String[] args) throws CharacterCodingException {
		Charset gbk=Charset.forName("GBK");
		CharsetEncoder gbkEncoder=gbk.newEncoder();
		CharsetDecoder gbkDecoder=gbk.newDecoder();
		
		CharBuffer cbuff=CharBuffer.allocate(10);
		cbuff.put('a');
		cbuff.put('b');
		cbuff.put('c');
		cbuff.flip();
		
		ByteBuffer bbuff=gbkEncoder.encode(cbuff);
		System.out.println(bbuff.capacity());
		System.out.println(bbuff.limit());
		System.out.println(bbuff.position());
		for(int i=0;i<bbuff.limit();i++) {
			System.out.print(bbuff.get(i));
		}
		
		System.out.println("\n"+gbkDecoder.decode(bbuff));
		
	}

}
