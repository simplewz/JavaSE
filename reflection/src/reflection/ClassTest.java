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
		System.out.println("执行有参构造器");
	}
	
	private void test() {
		System.out.println("私有方法");
	}
	
	public void info() {
		System.out.println("执行info的没有参数的方法");
	}
	
	public void info(String info) {
		System.out.println("执行info带一个参数方法,参数值为："+info);
	}
	
	//内部类
	class inner{
		
	}
	
	@Override
	public String toString() {
		return "ClassTest [field1=" + field1 + ", field2=" + field2 + "]";
	}

	public static void main(String[] args) throws Exception {
		Class<ClassTest> clazz=ClassTest.class;
		
		Package packageInfo = clazz.getPackage();
		System.out.println(clazz.getSimpleName()+"所在的包为："+packageInfo.getName());
		
		Annotation[] annotations=clazz.getAnnotations();
		System.out.println(clazz.getSimpleName()+"类上标注的注解如下：");
		for(Annotation annotation:annotations) {
			System.out.println(annotation);
		}
		
		Field[] fields=clazz.getDeclaredFields();
		System.out.println(clazz.getSimpleName()+"类上中属性信息如下：");
		for(Field field:fields) {
			System.out.println("属性："+field.getName()+"修饰符信息："+field.getModifiers()+",属性类型："+field.getType());
			System.out.println("属性："+field.getName()+"上添加的注解信息如下：");
			Annotation[] fieldAnnotations=field.getAnnotations();
			for(Annotation annotation:fieldAnnotations) {
				System.out.println(annotation);
			}
		}
		
		Constructor<ClassTest>[] constructors=(Constructor<ClassTest>[]) clazz.getConstructors();
		for(Constructor<ClassTest> constructor:constructors) {
			System.out.println(constructor);
		}
		//通过反射获取构造方法创建对象
		Constructor<ClassTest> constructor=clazz.getDeclaredConstructor(String.class,Integer.class);
		ClassTest instance=constructor.newInstance("simple",90);
		System.out.println(instance);	
		
		//获取所有的方法
		Method[] methods=clazz.getDeclaredMethods();
		for(Method method:methods) {
			System.out.println(method);
		}
		
		Method info=clazz.getMethod("info", String.class);
		info.invoke(instance, "测试打印输出");
		
		//获取私有方法
		Method test=clazz.getDeclaredMethod("test", null);
		//设置私有方法的访问属性为true,表名方法的调用不受访问控制符的限制
		test.setAccessible(true);
		System.out.println(test);
		//可通过反射调用私有方法
		test.invoke(instance, null);
		
		ClassTest instance2 = clazz.newInstance();
		System.out.println(instance2);
		
	}
}
