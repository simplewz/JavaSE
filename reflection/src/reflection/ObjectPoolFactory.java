package reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectPoolFactory {
	
	//存储对象的HashMap
	private Map<String,Object> objectMap=new HashMap<>();
	
	//使用反射根据类全限定名创建对象
	@SuppressWarnings("unchecked")
	private <T> T createObject(String className) throws Exception {
		Class<T> clazz=(Class<T>) Class.forName(className);
		return clazz.newInstance();
	}
	//从配置文件中读取对象配置信息
	public void initPool(String configFilePath) throws Exception {
		File file=new File(configFilePath);
		if(!file.exists()) {
			throw new FileNotFoundException("配置文件"+configFilePath+"不存在!");
		}
		FileInputStream fileInputStream=new FileInputStream(file);
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		for(String name:properties.stringPropertyNames()) {
			Object object=createObject(properties.getProperty(name));
			objectMap.put(name, object);
		}
		
		if(fileInputStream!=null) {
			fileInputStream.close();
		}
	}
	
	//根据对象名称从HashMap中获取创建的对象
	public Object getObject(String name) {
		return objectMap.get(name);
	}
	

	public static void main(String[] args) throws Exception {
		ObjectPoolFactory objectPoolFactory=new ObjectPoolFactory();
		objectPoolFactory.initPool("E:/learning/reflection/resources/object.properties");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(objectPoolFactory.getObject("today")));
		System.out.println(objectPoolFactory.getObject("today"));
		System.out.println(objectPoolFactory.getObject("classTest"));
	}
}
