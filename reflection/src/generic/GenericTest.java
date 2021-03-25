package generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月25日
 */
public class GenericTest {
	
	private Map<String,BigDecimal> score;

	public static void main(String[] args) throws Exception {
		Class<GenericTest> clazz=GenericTest.class;
		Field scoreField=clazz.getDeclaredField("score");
		Class<?> scoreType = scoreField.getType();
		System.out.println(scoreField.getName()+":"+scoreType);
		
		//获取field的泛型类型
		Type gType = scoreField.getGenericType();
		if(gType instanceof ParameterizedType) {
			//强制类型转换
			ParameterizedType pType=(ParameterizedType)gType;
			Type rType=pType.getRawType();
			System.out.println("原始类型是："+rType);
			//获取泛型类型的泛型参数
			Type[] tArgs=pType.getActualTypeArguments();
			System.out.println("泛型类型是：");
			for(int i=0;i<tArgs.length;i++) {
				System.out.println("第"+i+"个泛型类型是："+tArgs[i]);
			}
		}else {
			System.out.println("获取泛型类型出错");
		}
	}
}
