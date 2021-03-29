package thread;

/**
 * 	后台线程：后台线程在后台运行，为其他线程提供服务，可通过thread线程对象的setDaemon(true)将一个线程设置为后台线程
 *          当所有的前台线程执行完成后，后台线程也会随之结束
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月29日
 */
public class DaemonThread extends Thread{

	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(getName()+" "+i);
		}
	}

	public static void main(String[] args) {
		//创建一个后台线程并启动一个后台线程
		DaemonThread daemonThread= new DaemonThread();
		daemonThread.setName("daemonthread");
		//需要在调用线程的start方法之前调用，否则会抛出异常
		//daemonThread.start();
		daemonThread.setDaemon(true);
		daemonThread.start();
		
		//主线程为前台线程
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		
		//前台线程执行结束之后，即使后台线程的执行体没有执行完成也会退出
	}

}
