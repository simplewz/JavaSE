package thread.sync;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月29日
 */
public class DrawThread extends Thread{
	
	//private Account account;
	
	//private NewAccount account;
	
	private LockAccount account;
	
	private double drawAmount;
	
	/*
	public DrawThread(String name,Account account,double drawAmount) {
		super(name);
		this.account=account;
		this.drawAmount=drawAmount;
	}*/
	/*
	public DrawThread(String name,NewAccount account,double drawAmount) {
		super(name);
		this.account=account;
		this.drawAmount=drawAmount;
	}*/
	
	public DrawThread(String name,LockAccount account,double drawAmount) {
		super(name);
		this.account=account;
		this.drawAmount=drawAmount;
	}
	
	@Override
	public void run() {
		/*
		synchronized (account) {
			System.out.print(account);
			System.out.println(getName()+"开始取钱，取钱金额"+drawAmount);
			if(account.getBalance()>=drawAmount) {
				System.out.println("账户余额充足！");
				System.out.println("开始扣款！");
				account.setBalance(account.getBalance()-drawAmount);
				System.out.println("扣款成功！");
				System.out.println(getName()+"取钱"+drawAmount+",账户:"+account.getAccountNo()+"余额："+account.getBalance());
			}else {
				System.out.println("账户："+account.getAccountNo()+"余额:"+account.getBalance());
				System.out.println("账户余额不足，交易失败！");
			}
		}*/
		
		/*
		account.draw(drawAmount);
		*/
		
		account.draw(drawAmount);
		
	}
	
	public static void main(String[] args) {
		/*
		Account account=new Account("123456", 1000);
		System.out.println(account);
		new DrawThread("甲", account, 800).start();
		new DrawThread("乙", account, 500).start();
		*/
		/*
		NewAccount account=new NewAccount("123456", 1000);
		new DrawThread("甲", account, 800).start();
		new DrawThread("甲", account, 300).start();
		*/
		
		LockAccount account=new LockAccount("1234567", 1000);
		new DrawThread("甲", account, 800).start();
		new DrawThread("乙", account, 300).start();
	}
	
}
