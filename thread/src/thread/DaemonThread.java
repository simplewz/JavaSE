package thread;

/**
 * 	��̨�̣߳���̨�߳��ں�̨���У�Ϊ�����߳��ṩ���񣬿�ͨ��thread�̶߳����setDaemon(true)��һ���߳�����Ϊ��̨�߳�
 *          �����е�ǰ̨�߳�ִ����ɺ󣬺�̨�߳�Ҳ����֮����
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��29��
 */
public class DaemonThread extends Thread{

	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(getName()+" "+i);
		}
	}

	public static void main(String[] args) {
		//����һ����̨�̲߳�����һ����̨�߳�
		DaemonThread daemonThread= new DaemonThread();
		daemonThread.setName("daemonthread");
		//��Ҫ�ڵ����̵߳�start����֮ǰ���ã�������׳��쳣
		//daemonThread.start();
		daemonThread.setDaemon(true);
		daemonThread.start();
		
		//���߳�Ϊǰ̨�߳�
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		
		//ǰ̨�߳�ִ�н���֮�󣬼�ʹ��̨�̵߳�ִ����û��ִ�����Ҳ���˳�
	}

}
