package thread;

/**
 * ͨ��ʵ��Runnable�ӿڷ�װ�߳���Ҫִ�еĴ��봴���߳�
 * ͨ��ʵ��runnable�ӿ�ʵ�֣�������Լ̳������ֻ࣬�ǽ�����Ķ��߳�ִ�����װ��runnable�ӿڵ�run������ִ�С�
 * ��ͨ�����ַ�ʽʵ�ֵĶ��߳̿�ʵ�ֶ���߳�֮�乲������
 * @author wangzhao 13132398914@163.com
 */
public class SecondThread implements Runnable{
	
	private int i;

	//�߳�ִ����Ҫִ�еĴ���
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
				//ͨ������runnable�����װ���߳���Ҫִ�еĴ���
				//�߳�1���߳�2����st����st�����е������������̹߳���
				new Thread(st, "���߳�1").start();
				new Thread(st, "���߳�2").start();
			}
		}
	}
}
