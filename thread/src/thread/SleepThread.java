package thread;

/**
 *        �����̵߳�sleep���������߳�����
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��29��
 */
public class SleepThread {

	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			Thread.sleep(1000);
		}
	}
}
