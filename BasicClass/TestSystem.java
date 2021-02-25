import java.util.*;
import java.io.*;

public class TestSystem{
	public static void main(String[] args) throws Exception{
		/**
		 * get current system environments
		 */
		Map<String,String> env = System.getenv();
		System.out.println("Current System Environments Vars:");
		for(String name : env.keySet()){
			System.out.println(name+"="+env.get(name));
		}
		
		System.out.println(env.get("JAVA_HOME"));
		
		Properties props = System.getProperties();
		
		props.store(new FileOutputStream("system.propertis"),"System Properties");
		
		System.out.println(System.getProperty("os.name"));
		
	}
}