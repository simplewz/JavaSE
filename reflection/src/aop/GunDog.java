package aop;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��24��
 */
public class GunDog implements Dog{

	@Override
	public void info() {
		System.out.println("�Թ�");
	}

	@Override
	public void run() {
		System.out.println("�Թ��ı����ٶȽϿ�");
	}
}
