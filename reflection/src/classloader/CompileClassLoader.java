package classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * �Զ���������� ���˴��Զ����������ʵ�ֱ���Java������
 * @author wangzhao
 *
 */
public class CompileClassLoader extends ClassLoader{
	
	/**
	 * ��ȡָ���ļ��Ķ���������
	 * @param fileName   �ļ�����
	 * @return
	 * @throws IOException
	 */
	private byte[] getBytes(String fileName) throws IOException {
		File file=new File(fileName);
		if(!file.exists()) {
			throw new FileNotFoundException("�ļ���"+fileName+"������");
		}
		long length = file.length();
		byte[] raw=new byte[(int)length];
		FileInputStream inputStream=new FileInputStream(file);
		inputStream.read(raw);
		inputStream.close();
		return raw;
	} 
	
	/**
	 * ����javac���̱���ָ��java�ļ�
	 * @param javaFile
	 * @return
	 * @throws IOException
	 */
	private boolean complie(String javaFile) throws IOException {
		File file=new File(javaFile);
		if(!file.exists()) {
			throw new FileNotFoundException("�ļ���"+javaFile+"������");
		}
		if(!javaFile.endsWith(".java")) {
			System.out.println("�����ļ�����Java�ļ�,�������");
			System.out.println("ϵͳ�����˳���");
			System.exit(0);
		}
		System.out.println("CompileClassLoader���ڱ��룺"+javaFile);
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
				//����class�ļ�,��ø�class���Ӧ��Class����
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
			System.out.println("ȱ�����е�Ŀ���࣬�밴���¸�ʽ����JavaԴ�ļ���");
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
