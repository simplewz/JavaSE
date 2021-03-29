package thread;

/**
 * 通过实现Runnable接口封装线程需要执行的代码创建线程
 * 通过实现runnable接口实现，该类可以继承其他类，只是将该类的多线程执行体封装在runnable接口的run方法中执行。
 * 且通过这种方式实现的多线程可实现多个线程之间共享数据
 * @author wangzhao 13132398914@163.com
 */
public class SecondThread implements Runnable{
	
	private int i;

	//线程执行需要执行的代码
	@Override
	public void run() {
		for(;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}

	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			if(i==20) {
				SecondThread st=new SecondThread();
				//通过传入runnable对象封装了线程需要执行的代码
				//线程1和线程2共享st对象，st对象中的数据由两个线程共享
				new Thread(st, "新线程1").start();
				new Thread(st, "新线程2").start();
			}
		}
	}
}
