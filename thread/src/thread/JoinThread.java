package thread;

/**
 * 	�߳�join()����������һ���̵߳�ִ�����е����˱���̵߳�join����ʱ�����õ��߳̽���������ֱ��join���߳�(�����õ��߳�)
 * 	����̵߳�ִ����ʱ���Ż�ָ������̵߳�ִ�С����ַ�ʽͨ��Ӧ���ڽ�һ����������ֳ����С�����񣬽�С������ֱ���������߳�
 * 	ȥ��ɣ�Ȼ���ɵ��õ��߳��������Ļ��ܴ���
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��29��
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
