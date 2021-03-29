package thread.sync;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��29��
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
			System.out.println(getName()+"��ʼȡǮ��ȡǮ���"+drawAmount);
			if(account.getBalance()>=drawAmount) {
				System.out.println("�˻������㣡");
				System.out.println("��ʼ�ۿ");
				account.setBalance(account.getBalance()-drawAmount);
				System.out.println("�ۿ�ɹ���");
				System.out.println(getName()+"ȡǮ"+drawAmount+",�˻�:"+account.getAccountNo()+"��"+account.getBalance());
			}else {
				System.out.println("�˻���"+account.getAccountNo()+"���:"+account.getBalance());
				System.out.println("�˻����㣬����ʧ�ܣ�");
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
		new DrawThread("��", account, 800).start();
		new DrawThread("��", account, 500).start();
		*/
		/*
		NewAccount account=new NewAccount("123456", 1000);
		new DrawThread("��", account, 800).start();
		new DrawThread("��", account, 300).start();
		*/
		
		LockAccount account=new LockAccount("1234567", 1000);
		new DrawThread("��", account, 800).start();
		new DrawThread("��", account, 300).start();
	}
	
}
