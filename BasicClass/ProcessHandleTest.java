
import java.util.concurrent.CompletableFuture;

public class ProcessHandleTest{
	public static void main(String[] args) throws Exception{
		Runtime rt=Runtime.getRuntime();
		Process p=rt.exec("notepad.exe");
		ProcessHandle ph=p.toHandle();
		System.out.println("is process running?"+ph.isAlive());
		System.out.println("process id is:"+ph.pid());
		System.out.println("parent process is:"+ph.parent());
		ProcessHandle.Info info=ph.info();
		System.out.println("process command is:"+info.command());
		System.out.println("process param:"+info.arguments());
		System.out.println("process start time is:"+info.startInstant());
		System.out.println("process total runtime is:"+info.totalCpuDuration());
		CompletableFuture<ProcessHandle> cf=ph.onExit();
		cf.thenRunAsync(()->{System.out.println("exit process!");});
		Thread.sleep(5000);
	}
}
