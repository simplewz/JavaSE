package threadgroup;

/**
 * 自定义线程异常处理器
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年4月1日
 */
public class MyThreadHandler implements Thread.UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t+"线程出现异常，异常信息："+e);
	}
	
	public static void main(String[] args) {
		MyThreadHandler handler=new MyThreadHandler();
		Thread.currentThread().setUncaughtExceptionHandler(handler);
		int a=7/0;
	}

}
