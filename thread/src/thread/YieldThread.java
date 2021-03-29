package thread;

/**
 * yeild线程让步：调用该方法会让线程暂停执行，但是并不会让线程阻塞。调用该方法后线程会由执行状态重新转换为就绪状态，就绪状态的线程
 *       会又调度器进行调度执行。
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月29日
 */
public class YieldThread extends Thread{
	
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(getName()+" "+i);
			if(i==10) {
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) {
		YieldThread yieldThread1=new YieldThread();
		yieldThread1.setPriority(Thread.NORM_PRIORITY);
		yieldThread1.start();
		YieldThread yieldThread2=new YieldThread();
		yieldThread2.setPriority(MAX_PRIORITY);
		yieldThread2.start();
	}

}
