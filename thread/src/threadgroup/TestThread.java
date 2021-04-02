package threadgroup;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��4��1��
 */
public class TestThread extends Thread{

	public TestThread() {
		
	}
	
	public TestThread(String name) {
		super(name);
	}
	
	public TestThread(ThreadGroup group,String name) {
		super(group, name);
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println(getName()+"  "+i);
		}
	}
	
	public static void main(String[] args) {
		//��ȡ��ǰ���̵߳����ڵ��߳���
		ThreadGroup mainGroup=Thread.currentThread().getThreadGroup();
		//���߳�������
		System.out.println("���߳����ڵ��߳��飺"+mainGroup.getName());
		//���߳����Ƿ��Ǻ�̨�߳�
		System.out.println("���߳����ڵ��߳����Ƿ���Daemon�̣߳�"+mainGroup.isDaemon());
		//���߳����л�Ծ���߳�����
		System.out.println("���߳����ڵ��߳����Ծ���߳�������"+mainGroup.activeCount());
		
		//�������߳��鴴��һ����Ϊ�����߳�����¼ӵ��߳�   ���߳�
		TestThread testThread=new TestThread(mainGroup, "���߳�����¼ӵ��߳�");
		testThread.start();
		//���߳�����̻߳�Ծ����+1
		System.out.println("���߳����ڵ��߳����Ծ���߳�������"+mainGroup.activeCount());
		
		
		//�����µ��߳���
		ThreadGroup newGroup=new ThreadGroup("���߳���");
		newGroup.setDaemon(true);
		TestThread testThread2=new TestThread(newGroup, "�����߳�");
		testThread2.start();
		
	}
	
}
