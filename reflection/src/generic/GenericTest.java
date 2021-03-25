package generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��25��
 */
public class GenericTest {
	
	private Map<String,BigDecimal> score;

	public static void main(String[] args) throws Exception {
		Class<GenericTest> clazz=GenericTest.class;
		Field scoreField=clazz.getDeclaredField("score");
		Class<?> scoreType = scoreField.getType();
		System.out.println(scoreField.getName()+":"+scoreType);
		
		//��ȡfield�ķ�������
		Type gType = scoreField.getGenericType();
		if(gType instanceof ParameterizedType) {
			//ǿ������ת��
			ParameterizedType pType=(ParameterizedType)gType;
			Type rType=pType.getRawType();
			System.out.println("ԭʼ�����ǣ�"+rType);
			//��ȡ�������͵ķ��Ͳ���
			Type[] tArgs=pType.getActualTypeArguments();
			System.out.println("���������ǣ�");
			for(int i=0;i<tArgs.length;i++) {
				System.out.println("��"+i+"�����������ǣ�"+tArgs[i]);
			}
		}else {
			System.out.println("��ȡ�������ͳ���");
		}
	}
}
