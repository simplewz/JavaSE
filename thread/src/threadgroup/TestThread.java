package threadgroup;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021年4月1日
 */
public class TestThread extends Thread{

	public TestThread() {
		
	}
	
	public TestThread(String name) {
		super(name);
	}
	
	public TestThread(ThreadGroup group,String name) {
		super(group, name);
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println(getName()+"  "+i);
		}
	}
	
	public static void main(String[] args) {
		//获取当前主线程的所在的线程组
		ThreadGroup mainGroup=Thread.currentThread().getThreadGroup();
		//主线程组名称
		System.out.println("主线程所在的线程组："+mainGroup.getName());
		//主线程组是否是后台线程
		System.out.println("主线程所在的线程组是否是Daemon线程："+mainGroup.isDaemon());
		//主线程组中活跃的线程数量
		System.out.println("主线程所在的线程组活跃的线程数量："+mainGroup.activeCount());
		
		//以主线线程组创建一个名为：主线程组的新加的线程   的线程
		TestThread testThread=new TestThread(mainGroup, "主线程组的新加的线程");
		testThread.start();
		//主线程组的线程活跃数量+1
		System.out.println("主线程所在的线程组活跃的线程数量："+mainGroup.activeCount());
		
		
		//创建新的线程组
		ThreadGroup newGroup=new ThreadGroup("新线程组");
		newGroup.setDaemon(true);
		TestThread testThread2=new TestThread(newGroup, "测试线程");
		testThread2.start();
		
	}
	
}
