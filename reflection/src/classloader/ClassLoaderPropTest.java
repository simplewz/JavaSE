package classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {

	public static void main(String[] args) throws IOException {
		//��ȡϵͳ�������
		ClassLoader systemLoader=ClassLoader.getSystemClassLoader();
		System.out.println("ϵͳ���������"+systemLoader);
		//�鿴ϵͳ����������ص���Դ,ͨ��ָ��ǰ·��
		Enumeration<URL> eml = systemLoader.getResources("");
		while(eml.hasMoreElements()) {
			System.out.println(eml.nextElement());
		}
		
		//��ȡ��չ�������
		ClassLoader parentClassLoader=systemLoader.getParent();
		System.out.println("��չ���������"+parentClassLoader);
		System.out.println("��չ��������ļ���·����"+System.getProperty("java.ext.dirs"));
		
		//��ȥ���������
		System.out.println("��չ���������parent:"+parentClassLoader.getParent());
	}
 
}
