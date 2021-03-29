package thread;

/**
 * 	线程join()方法：当在一个线程的执行流中调用了别的线程的join方法时，调用的线程将被阻塞，直到join的线程(被调用的线程)
 * 	完成线程的执行体时，才会恢复调用线程的执行。这种方式通常应用于将一个大的任务拆分成许多小的任务，将小的任务分别分配给别的线程
 * 	去完成，然后由调用的线程完成任务的汇总处理。
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月29日
 */
public class JoinThread extends Thread{

	public JoinThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for( int i=0;i<100;i++) {
			System.out.println(getName()+"  "+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		JoinThread joinThread=new JoinThread("join thread");
		for(int i=0;i<300;i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i);
			if(i==10) {
				joinThread.start();
				joinThread.join();
			}
		}
	}
}
