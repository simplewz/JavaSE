package thread.notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��30��
 */
public class LockAccount {
	
	private final ReentrantLock lock=new ReentrantLock();
	
	private final Condition condition=lock.newCondition();

	private String accountNo;
	
	private double balance;
	
	//�˻���Ǯ��־,falgΪtrueʱ��ʾ�˻��д�����ȡǮ��Ϊfalseʱ��ʾ�˻�û�д����Դ�Ǯ
	private boolean flag;

	public LockAccount() {
		super();
	}

	public LockAccount(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void draw(double drawAmount) {
		lock.lock();
		System.out.println(this);
		try {
			if(!flag) {
				System.out.println("�˻�û�д�ȡǮ��������");
				condition.await();
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
				flag=false;
				condition.signalAll();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void deposit(double depositAmount) {
		lock.lock();
		System.out.println(this);
		try {
			if(flag) {
				System.out.println("�˻��Ѿ��д���Ǯ��������");
				condition.await();
			}else {
				System.out.println("��ʼ������"+depositAmount);
				balance+=depositAmount;
				System.out.println("���ɹ���");
				System.out.println("���ɹ��������˻����Ϊ:"+balance);
				flag=true;
				condition.signalAll();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
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
		LockAccount other = (LockAccount) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}
}
