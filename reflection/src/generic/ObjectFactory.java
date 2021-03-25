package generic;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��25��
 */
public class ObjectFactory {
	
	public static Object getInstance(String className) {
		try {
			Class clazz=Class.forName(className);
			return clazz.newInstance();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
