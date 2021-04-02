package thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author simple
 * @email 13132398914@163.com
 * @date 2021Äê4ÔÂ1ÈÕ
 */
public class TestExecutors {

	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		TestThread testThread=new TestThread();
		executorService.submit(testThread);
		executorService.submit(new TestThread());
		executorService.shutdown();
	}

}
