package thread.notify;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月30日
 */
public class Account {
	
	private String accountNo;
	
	private double balance;
	
	//账户存钱标志,falg为true时表示账户有存款，可以取钱，为false时表示账户没有存款，可以存钱
	private boolean flag;

	public Account() {
		super();
	}

	public Account(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public synchronized void draw(double drawAmount) throws InterruptedException {
		System.out.println(this);
		//flag为false，表示没有人存钱进账户
		if(!flag) {
			System.out.println("账户没有存款，取钱方法阻塞");
			wait();
		}else {
			System.out.println("账户有存款，执行正常的取钱业务");
			if(balance>=drawAmount) {
				System.out.println("账户余额充足，即将进行扣款");
				System.out.println("开始扣款，扣款金额："+drawAmount);
				balance-=drawAmount;
				System.out.println("扣款成功！");
				System.out.println("交易成功，账户余额："+balance);
			}else {
				System.out.println("账户余额："+balance);
				System.out.println("账户余额不足，交易失败！");
			}
			//取钱业务流程结束，将flag改为false，需要有人存钱进入账户才能进行取钱业务
			flag=false;
			//唤醒其他存钱的线程存款
			notifyAll();
		}
	}
	
	public synchronized void deposit(double depositAmount) throws InterruptedException {
		System.out.println(this);
		if(flag) {
			System.out.println("账户已经有存款，存钱方法阻塞");
			wait();
		}else {
			System.out.println("开始存款，存款金额："+depositAmount);
			balance+=depositAmount;
			System.out.println("存款成功！");
			System.out.println("存款成功，存款后账户余额为:"+balance);
			//修改存款标志为true，表名有存款
			flag=true;
			//唤醒其他线程
			notifyAll();
		}
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (flag ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (flag != other.flag)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance + "]";
	}
	
}
