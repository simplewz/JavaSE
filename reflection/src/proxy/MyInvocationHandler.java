package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("����ִ�еķ�����"+method);
		if(args!=null) {
			System.out.println("ִ�з���ʱ����Ĳ�����");
			for(Object arg:args) {
				System.out.println(arg);
			}
		}else {
			System.out.println("���ø÷������ô���");
		}
		return null;
		//return method.invoke(proxy, args);
	}
}
