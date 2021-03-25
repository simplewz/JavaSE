package proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		InvocationHandler handler=new MyInvocationHandler();
		Class proxyClass=Proxy.getProxyClass(ClassLoader.getSystemClassLoader(), new Class[] {Action.class});
		Constructor constructor=proxyClass.getConstructor(new Class[] {InvocationHandler.class});
		Action action1=(Action) constructor.newInstance(new Object[] {handler});
		action1.walk();
		action1.sayHello("hello");
		

		System.out.println("=========================");
		Action action=(Action)Proxy.newProxyInstance(Action.class.getClassLoader(), new Class[] {Action.class}, handler);
		action.walk();
		action.sayHello("simple");
	}
}
