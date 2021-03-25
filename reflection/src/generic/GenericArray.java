package generic;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021Äê3ÔÂ25ÈÕ
 */
public class GenericArray {
	
	@SuppressWarnings("unchecked")
	public static <T> T[] newInstance(Class<T> componentType,int length) {
		return (T[])Array.newInstance(componentType, length);
	}
	
	public static void main(String[] args) {
		String[] bookArray=newInstance(String.class, 10);
		bookArray[0]=new String("Java");
		bookArray[1]=new String("C++");
		
		System.out.println(Arrays.asList(bookArray));
		
		
		int[][] intArray=newInstance(int[].class, 5);
		intArray[2]= new int[] {22,18};
		intArray[0]= new int[] {39,98,80};
		for(int i=0;i<intArray.length;i++) {
			if(intArray[i]!=null) {
				for(int j=0;j<intArray[i].length;j++) {
					System.out.println(intArray[i][j]);
				}
			}
		}
	}
}
