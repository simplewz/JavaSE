package classloader;

import java.net.URL;

/**
 * JAVA BootStrap ClassLoader�����������������ЩJava�������
 * @author admin
 *
 */
public class BootStrapClassLoaderTest {

	public static void main(String[] args) {
		//�鿴�����������������ЩJava������
		/*
		URL[] uri=sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for(URL url:uri) {
			System.out.println(url.toExternalForm());
		}*/
		/* ������������ص���Դ
		 * file:/D:/dev/jdk/jre/lib/resources.jar
		 * file:/D:/dev/jdk/jre/lib/rt.jar
		 * file:/D:/dev/jdk/jre/lib/sunrsasign.jar
		 * file:/D:/dev/jdk/jre/lib/jsse.jar
		 * file:/D:/dev/jdk/jre/lib/jce.jar
		 * file:/D:/dev/jdk/jre/lib/charsets.jar
		 * file:/D:/dev/jdk/jre/lib/jfr.jar
		 * file:/D:/dev/jdk/jre/classes
		 */
	}

}
