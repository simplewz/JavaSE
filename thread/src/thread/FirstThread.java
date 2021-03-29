package thread;

/**
    *     通过继承Thread类创建线程,将需要完成的任务在run方法中进行封装
    *     通过继承线程类限制类的继承关系,该类只能是线程类对象。且多个线程之间不能共享数据，每个线程只能持有自己的数据
 * @author wangzhao 13132398914
 */
public class FirstThread extends Thread{
	
	private int i=0;
	
	//线程需要完成的任务,即线程的执行体
	@Override
	public void run() {
		for(;i<100;i++) {
			System.out.println(getName()+":"+i);
		}
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			if(i==20) {
				//启动线程调用线程的start()方法，而不是run方法
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}
}
