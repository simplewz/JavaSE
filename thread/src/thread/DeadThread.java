package thread;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月29日
 */
public class DeadThread extends Thread {

	private int i;
	
	@Override
	public void run() {
		for(;i<100;i++) {
			System.out.println(getName()+"  "+i);
		}
	}

	public static void main(String[] args) {
		DeadThread deadThread=new DeadThread();
		for(int i=0;i<300;i++) {
			if(i==30) {
				deadThread.start();
				//调用线程的isAlive方法，
				//线程处于 就绪、运行、阻塞  状态时返回true
				//线程处于 新建 死亡 状态时返回false
				System.out.println("deadThread is Alive:"+deadThread.isAlive());
			}
			
			if(i>30&&deadThread.isAlive()) {
				//再次调用线程的start方法,  抛出java.lang.IllegalThreadStateException异常
				deadThread.start();
			}
		}
	}
}
