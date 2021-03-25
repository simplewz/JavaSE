package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.xml.ws.soap.Addressing;

@SuppressWarnings(value = "unchecked")
@Deprecated
public class ClassTest {
	
	@Addressing
	private String field1;
	
	public Integer field2;
	
	public ClassTest() {
		
	}
	
	public ClassTest(String field1,Integer field2) {
		this.field1=field1;
		this.field2=field2;
		System.out.println("ִ���вι�����");
	}
	
	private void test() {
		System.out.println("˽�з���");
	}
	
	public void info() {
		System.out.println("ִ��info��û�в����ķ���");
	}
	
	public void info(String info) {
		System.out.println("ִ��info��һ����������,����ֵΪ��"+info);
	}
	
	//�ڲ���
	class inner{
		
	}
	
	@Override
	public String toString() {
		return "ClassTest [field1=" + field1 + ", field2=" + field2 + "]";
	}

	public static void main(String[] args) throws Exception {
		Class<ClassTest> clazz=ClassTest.class;
		
		Package packageInfo = clazz.getPackage();
		System.out.println(clazz.getSimpleName()+"���ڵİ�Ϊ��"+packageInfo.getName());
		
		Annotation[] annotations=clazz.getAnnotations();
		System.out.println(clazz.getSimpleName()+"���ϱ�ע��ע�����£�");
		for(Annotation annotation:annotations) {
			System.out.println(annotation);
		}
		
		Field[] fields=clazz.getDeclaredFields();
		System.out.println(clazz.getSimpleName()+"������������Ϣ���£�");
		for(Field field:fields) {
			System.out.println("���ԣ�"+field.getName()+"���η���Ϣ��"+field.getModifiers()+",�������ͣ�"+field.getType());
			System.out.println("���ԣ�"+field.getName()+"����ӵ�ע����Ϣ���£�");
			Annotation[] fieldAnnotations=field.getAnnotations();
			for(Annotation annotation:fieldAnnotations) {
				System.out.println(annotation);
			}
		}
		
		Constructor<ClassTest>[] constructors=(Constructor<ClassTest>[]) clazz.getConstructors();
		for(Constructor<ClassTest> constructor:constructors) {
			System.out.println(constructor);
		}
		//ͨ�������ȡ���췽����������
		Constructor<ClassTest> constructor=clazz.getDeclaredConstructor(String.class,Integer.class);
		ClassTest instance=constructor.newInstance("simple",90);
		System.out.println(instance);	
		
		//��ȡ���еķ���
		Method[] methods=clazz.getDeclaredMethods();
		for(Method method:methods) {
			System.out.println(method);
		}
		
		Method info=clazz.getMethod("info", String.class);
		info.invoke(instance, "���Դ�ӡ���");
		
		//��ȡ˽�з���
		Method test=clazz.getDeclaredMethod("test", null);
		//����˽�з����ķ�������Ϊtrue,���������ĵ��ò��ܷ��ʿ��Ʒ�������
		test.setAccessible(true);
		System.out.println(test);
		//��ͨ���������˽�з���
		test.invoke(instance, null);
		
		ClassTest instance2 = clazz.newInstance();
		System.out.println(instance2);
		
	}
}
