package generic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月25日
 */
public class Client {

	public static void main(String[] args) {
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		//强制类型转换
		Date date=(Date)ObjectFactory.getInstance("java.util.Date");
		System.out.println(format.format(date));
		
		//不需要进行强制类型转化
		Date date2=GenericObjectFactory.getInstance(Date.class);
		System.out.println(format.format(date2));
	}

}
