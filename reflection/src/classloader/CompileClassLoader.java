package classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器 ，此处自定义类加载器实现编译Java程序功能
 * @author wangzhao
 *
 */
public class CompileClassLoader extends ClassLoader{
	
	/**
	 * 获取指定文件的二进制数据
	 * @param fileName   文件名称
	 * @return
	 * @throws IOException
	 */
	private byte[] getBytes(String fileName) throws IOException {
		File file=new File(fileName);
		if(!file.exists()) {
			throw new FileNotFoundException("文件："+fileName+"不存在");
		}
		long length = file.length();
		byte[] raw=new byte[(int)length];
		FileInputStream inputStream=new FileInputStream(file);
		inputStream.read(raw);
		inputStream.close();
		return raw;
	} 
	
	/**
	 * 调用javac进程编译指定java文件
	 * @param javaFile
	 * @return
	 * @throws IOException
	 */
	private boolean complie(String javaFile) throws IOException {
		File file=new File(javaFile);
		if(!file.exists()) {
			throw new FileNotFoundException("文件："+javaFile+"不存在");
		}
		if(!javaFile.endsWith(".java")) {
			System.out.println("编译文件不是Java文件,编译出错！");
			System.out.println("系统即将退出！");
			System.exit(0);
		}
		System.out.println("CompileClassLoader正在编译："+javaFile);
		Process process=Runtime.getRuntime().exec("javac "+javaFile);
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int pretV=process.exitValue();
		return pretV==0;
	}
	

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class clazz=null;
		String fileStub=name.replace(".", "/");
		String javaFileName=fileStub+".java";
		String classFileName=fileStub+".class";
		File javaFile=new File(javaFileName);
		File classFile=new File(classFileName);
		if((javaFile.exists()&&(!classFile.exists()))||javaFile.lastModified()>classFile.lastModified()) {
			try {
				if(!complie(javaFileName)||!classFile.exists()) {
					throw new ClassNotFoundException("ClassNotFoundException:"+javaFileName);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(classFile.exists()) {
			try {
				byte[] raw=getBytes(classFileName);
				//加载class文件,获得该class类对应的Class对象
				clazz = defineClass(name, raw, 0, raw.length);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(clazz==null) {
			throw new ClassNotFoundException(name);
		}
		
		return clazz;
	}

	public static void main(String[] args) throws Exception {
		
		if(args.length<1) {
			System.out.println("缺少运行的目标类，请按如下格式运行Java源文件：");
			System.out.println("java CompileClassLoader ClassName");
		}
		
		String progClass=args[0];
		String[] progArgs=new String[args.length-1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		CompileClassLoader ccl=new CompileClassLoader();
		Class<?> clazz=ccl.loadClass(progClass);
		Method main=clazz.getMethod("main", (new String[0]).getClass());
		Object[] argsArray= {progArgs};
		main.invoke(null, argsArray);
	}
}
