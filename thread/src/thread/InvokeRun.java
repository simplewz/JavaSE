package thread;

public class InvokeRun extends Thread{
	
	private int i;
	
	@Override
	public void run() {
		for(;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20) {
				//�����߳����run�����뵱�������ͨ����ķ��������ᴴ���µ��߳�
				new InvokeRun().run();
				new InvokeRun().run();
			}
		}
	}
}
