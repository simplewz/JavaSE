package thread.executors;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��4��1��
 */
public class TestThread implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<=100;i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i);
		}
	}
}
