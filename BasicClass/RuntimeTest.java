public class RuntimeTest{
	public static void main(String[] args){
		Runtime rt=Runtime.getRuntime();
		System.out.println("the JVM processors number is:"+rt.availableProcessors());
		System.out.println("the JVM free memory is:"+rt.freeMemory());
		System.out.println("the JVM total memory is:"+rt.totalMemory());
		System.out.println("the JVM max memory is:"+rt.maxMemory());
	}
}
