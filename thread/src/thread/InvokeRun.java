package thread;

public class InvokeRun extends Thread{
	
	private int i;
	
	@Override
	public void run() {
		for(;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20) {
				//调用线程类的run方法想当与调用普通对象的方法，不会创建新的线程
				new InvokeRun().run();
				new InvokeRun().run();
			}
		}
	}
}
