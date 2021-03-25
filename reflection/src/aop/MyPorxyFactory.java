package aop;

import java.lang.reflect.Proxy;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021��3��24��
 */
public class MyPorxyFactory {
	public static Object getProxy(Object target) {
		MyInvokationHandler handler=new MyInvokationHandler(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
	}
}
