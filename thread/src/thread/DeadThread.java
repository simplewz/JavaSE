package thread;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��29��
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
				//�����̵߳�isAlive������
				//�̴߳��� ���������С�����  ״̬ʱ����true
				//�̴߳��� �½� ���� ״̬ʱ����false
				System.out.println("deadThread is Alive:"+deadThread.isAlive());
			}
			
			if(i>30&&deadThread.isAlive()) {
				//�ٴε����̵߳�start����,  �׳�java.lang.IllegalThreadStateException�쳣
				deadThread.start();
			}
		}
	}
}
