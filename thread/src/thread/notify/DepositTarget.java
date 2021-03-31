package thread.notify;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021Äê3ÔÂ30ÈÕ
 */
public class DepositTarget implements Runnable{
	
	private Account account;
	
	private double depositAmount;

	public DepositTarget(Account account, double depositAmount) {
		super();
		this.account = account;
		this.depositAmount = depositAmount;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				account.deposit(depositAmount);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
