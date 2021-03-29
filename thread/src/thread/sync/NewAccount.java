package thread.sync;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��29��
 */
public class NewAccount {
	
	private String accountNo;
	
	private volatile double balance;

	public NewAccount() {
		super();
	}

	public NewAccount(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	
	public synchronized void draw(double drawAmount) {
		System.out.println(this);
		System.out.println("ȡ���"+drawAmount);
		if(this.balance>=drawAmount) {
			System.out.println("�˻������㣡");
			System.out.println("��ʼ�ۿ");
			this.balance=this.balance-drawAmount;
			System.out.println("�ۿ�ɹ���");
			System.out.println("���׳ɹ����˻���"+balance);
		}else {
			System.out.println("�˻����Ϊ��"+balance);
			System.out.println("�˻����㣬����ʧ�ܣ�");
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
		NewAccount other = (NewAccount) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NewAccount [accountNo=" + accountNo + ", balance=" + balance + "]";
	}

}
