package aop;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021Äê3ÔÂ24ÈÕ
 */
public class Client {
	
	public static void main(String[] args) {
		Dog target=new GunDog();
		Dog proxy=(Dog) MyPorxyFactory.getProxy(target);
		proxy.info();
		proxy.run();
	}
}
