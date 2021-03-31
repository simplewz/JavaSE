package thread.notify;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021Äê3ÔÂ30ÈÕ
 */
public class DrawTarget implements Runnable{
	
	private Account account;
	
	private double drawAmount;

	public DrawTarget(Account account,double drawAmount) {
		super();
		this.account = account;
		this.drawAmount=drawAmount;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				account.draw(drawAmount);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
