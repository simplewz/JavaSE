package aop;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月24日
 */
public class GunDog implements Dog{

	@Override
	public void info() {
		System.out.println("猎狗");
	}

	@Override
	public void run() {
		System.out.println("猎狗的奔跑速度较快");
	}
}
