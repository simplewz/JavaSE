package thread.notify;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��30��
 */
public class Account {
	
	private String accountNo;
	
	private double balance;
	
	//�˻���Ǯ��־,falgΪtrueʱ��ʾ�˻��д�����ȡǮ��Ϊfalseʱ��ʾ�˻�û�д����Դ�Ǯ
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
		//flagΪfalse����ʾû���˴�Ǯ���˻�
		if(!flag) {
			System.out.println("�˻�û�д�ȡǮ��������");
			wait();
		}else {
			System.out.println("�˻��д�ִ��������ȡǮҵ��");
			if(balance>=drawAmount) {
				System.out.println("�˻������㣬�������пۿ�");
				System.out.println("��ʼ�ۿ�ۿ��"+drawAmount);
				balance-=drawAmount;
				System.out.println("�ۿ�ɹ���");
				System.out.println("���׳ɹ����˻���"+balance);
			}else {
				System.out.println("�˻���"+balance);
				System.out.println("�˻����㣬����ʧ�ܣ�");
			}
			//ȡǮҵ�����̽�������flag��Ϊfalse����Ҫ���˴�Ǯ�����˻����ܽ���ȡǮҵ��
			flag=false;
			//����������Ǯ���̴߳��
			notifyAll();
		}
	}
	
	public synchronized void deposit(double depositAmount) throws InterruptedException {
		System.out.println(this);
		if(flag) {
			System.out.println("�˻��Ѿ��д���Ǯ��������");
			wait();
		}else {
			System.out.println("��ʼ������"+depositAmount);
			balance+=depositAmount;
			System.out.println("���ɹ���");
			System.out.println("���ɹ��������˻����Ϊ:"+balance);
			//�޸Ĵ���־Ϊtrue�������д��
			flag=true;
			//���������߳�
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
