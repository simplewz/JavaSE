package thread;

/**
 * yeild�߳��ò������ø÷��������߳���ִͣ�У����ǲ��������߳����������ø÷������̻߳���ִ��״̬����ת��Ϊ����״̬������״̬���߳�
 *       ���ֵ��������е���ִ�С�
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��29��
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
