package thread;

/**
    *     ͨ���̳�Thread�ഴ���߳�,����Ҫ��ɵ�������run�����н��з�װ
    *     ͨ���̳��߳���������ļ̳й�ϵ,����ֻ�����߳�������Ҷ���߳�֮�䲻�ܹ������ݣ�ÿ���߳�ֻ�ܳ����Լ�������
 * @author wangzhao 13132398914
 */
public class FirstThread extends Thread{
	
	private int i=0;
	
	//�߳���Ҫ��ɵ�����,���̵߳�ִ����
	@Override
	public void run() {
		for(;i<100;i++) {
			System.out.println(getName()+":"+i);
		}
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			if(i==20) {
				//�����̵߳����̵߳�start()������������run����
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}
}
