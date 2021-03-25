package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年3月24日
 */
public class MyInvokationHandler implements InvocationHandler{
	
	private Object target;
	
	public MyInvokationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(Objects.isNull(target)) {
			System.out.println("被代理的对象不能为空！");
			System.exit(0);
		}
		CommonUtil util=new CommonUtil();
		util.method1();
		method.invoke(target, args);
		util.method2();
		return null;
	}
}
