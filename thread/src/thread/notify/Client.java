package thread.notify;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��30��
 */
public class Client {

	public static void main(String[] args) {
		Account account=new Account("1234567", 0);
		DrawTarget drawTarget=new DrawTarget(account, 200);
		DepositTarget depositTarget=new DepositTarget(account, 200);
		Thread drawThread=new Thread(drawTarget,"ȡǮ�߳�");
		Thread depositThread1=new Thread(depositTarget, "��Ǯ�߳�1");
		Thread depositThread2=new Thread(depositTarget, "��Ǯ�߳�2");
		
		drawThread.start();
		depositThread1.start();
		depositThread2.start();
	}

}
