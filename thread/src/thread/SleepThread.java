package thread;

/**
 *        调用线程的sleep方法，让线程阻塞
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月29日
 */
public class SleepThread {

	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			Thread.sleep(1000);
		}
	}
}
