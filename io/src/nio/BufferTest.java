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
		
		System.out.println("-----��� a��b��c 3��Ԫ�غ�-----");
		System.out.println("mark:"+buff.mark());
		System.out.println("position:"+buff.position());
		System.out.println("limit:"+buff.limit());
		System.out.println("capacity:"+buff.capacity());
		
		buff.flip();
		System.out.println("-----����flip()��---------");
		System.out.println("mark:"+buff.mark());
		System.out.println("position:"+buff.position());
		System.out.println("limit:"+buff.limit());
		System.out.println("capacity:"+buff.capacity());
		
		char first = buff.get();
		System.out.println("-----ȡ����һ��Ԫ��:"+first+"֮��-----");
		System.out.println("mark:"+buff.mark());
		System.out.println("position:"+buff.position());
		System.out.println("limit:"+buff.limit());
		System.out.println("capacity:"+buff.capacity());
		
		buff.clear();
		System.out.println("------����clear()��--------");
		System.out.println("mark:"+buff.mark());
		System.out.println("position:"+buff.position());
		System.out.println("limit:"+buff.limit());
		System.out.println("capacity:"+buff.capacity());
		
	}

}
