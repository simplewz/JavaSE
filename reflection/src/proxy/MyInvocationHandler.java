package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("正在执行的方法："+method);
		if(args!=null) {
			System.out.println("执行方法时传入的参数：");
			for(Object arg:args) {
				System.out.println(arg);
			}
		}else {
			System.out.println("调用该方法不用传参");
		}
		return null;
		//return method.invoke(proxy, args);
	}
}
