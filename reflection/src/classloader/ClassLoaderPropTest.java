package classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {

	public static void main(String[] args) throws IOException {
		//获取系统类加载器
		ClassLoader systemLoader=ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器："+systemLoader);
		//查看系统类加载器加载的资源,通常指当前路径
		Enumeration<URL> eml = systemLoader.getResources("");
		while(eml.hasMoreElements()) {
			System.out.println(eml.nextElement());
		}
		
		//获取扩展类加载器
		ClassLoader parentClassLoader=systemLoader.getParent();
		System.out.println("扩展类加载器："+parentClassLoader);
		System.out.println("扩展类加载器的加载路径："+System.getProperty("java.ext.dirs"));
		
		//或去根类加载器
		System.out.println("扩展类加载器的parent:"+parentClassLoader.getParent());
	}
 
}
