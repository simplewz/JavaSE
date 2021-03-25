package classloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class URLClassLoaderTest {
	
	public static Connection getConnection(String url,String user,String password) throws Exception {
		URL[] urls= {new URL("file://mysql-connector-java-8.0.22.jar")};
		//URLClassLoader,֧�ִ�URL·���м����࣬��֧�ֵĳ�����Э���У�http,ftp,file
		URLClassLoader urlClassLoader=new URLClassLoader(urls);
		Driver driver =(Driver)urlClassLoader.loadClass("com.mysql.cj.jdbc.Driver").newInstance();
		Properties prop=new Properties();
		prop.put("user", user);
		prop.put("password", password);
		Connection connection=driver.connect(url, prop);
		return connection;
	}
	

	public static void main(String[] args) throws Exception {
		System.out.println(getConnection("jdbc:mysql://localhost:3306/world?serverTimezone=UTC","root","wangzhao@2020"));
	}
}
