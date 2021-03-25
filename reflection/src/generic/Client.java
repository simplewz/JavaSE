package generic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��25��
 */
public class Client {

	public static void main(String[] args) {
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		//ǿ������ת��
		Date date=(Date)ObjectFactory.getInstance("java.util.Date");
		System.out.println(format.format(date));
		
		//����Ҫ����ǿ������ת��
		Date date2=GenericObjectFactory.getInstance(Date.class);
		System.out.println(format.format(date2));
	}

}
