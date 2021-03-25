package generic;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��25��
 */
public class GenericObjectFactory {
	
	public static <T> T getInstance(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
