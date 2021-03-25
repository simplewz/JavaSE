package reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectPoolFactory {
	
	//�洢�����HashMap
	private Map<String,Object> objectMap=new HashMap<>();
	
	//ʹ�÷��������ȫ�޶�����������
	@SuppressWarnings("unchecked")
	private <T> T createObject(String className) throws Exception {
		Class<T> clazz=(Class<T>) Class.forName(className);
		return clazz.newInstance();
	}
	//�������ļ��ж�ȡ����������Ϣ
	public void initPool(String configFilePath) throws Exception {
		File file=new File(configFilePath);
		if(!file.exists()) {
			throw new FileNotFoundException("�����ļ�"+configFilePath+"������!");
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
	
	//���ݶ������ƴ�HashMap�л�ȡ�����Ķ���
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
