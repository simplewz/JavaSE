package threadgroup;

/**
 * �Զ����߳��쳣������
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��4��1��
 */
public class MyThreadHandler implements Thread.UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t+"�̳߳����쳣���쳣��Ϣ��"+e);
	}
	
	public static void main(String[] args) {
		MyThreadHandler handler=new MyThreadHandler();
		Thread.currentThread().setUncaughtExceptionHandler(handler);
		int a=7/0;
	}

}
