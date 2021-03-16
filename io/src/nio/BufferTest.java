package nio;

import java.nio.CharBuffer;

public class BufferTest {
	public static void main(String[] args) {
		CharBuffer buff=CharBuffer.allocate(8);
		System.out.println("----initlize-----");
		System.out.println("mark:"+buff.mark());
		System.out.println("position:"+buff.position());
		System.out.println("limit:"+buff.limit());
		System.out.println("capacity:"+buff.capacity());
		
		buff.put('a');
		buff.put('b');
		buff.put('c');
		
		System.out.println("-----添加 a、b、c 3个元素后-----");
		System.out.println("mark:"+buff.mark());
		System.out.println("position:"+buff.position());
		System.out.println("limit:"+buff.limit());
		System.out.println("capacity:"+buff.capacity());
		
		buff.flip();
		System.out.println("-----调用flip()后---------");
		System.out.println("mark:"+buff.mark());
		System.out.println("position:"+buff.position());
		System.out.println("limit:"+buff.limit());
		System.out.println("capacity:"+buff.capacity());
		
		char first = buff.get();
		System.out.println("-----取出第一个元素:"+first+"之后-----");
		System.out.println("mark:"+buff.mark());
		System.out.println("position:"+buff.position());
		System.out.println("limit:"+buff.limit());
		System.out.println("capacity:"+buff.capacity());
		
		buff.clear();
		System.out.println("------调用clear()后--------");
		System.out.println("mark:"+buff.mark());
		System.out.println("position:"+buff.position());
		System.out.println("limit:"+buff.limit());
		System.out.println("capacity:"+buff.capacity());
		
	}

}
