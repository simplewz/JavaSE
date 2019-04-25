public class IdentityHashCodeTest{
	public static void main(String[] args){
		String s1=new String("Simple");
		String s2=new String("Simple");
		System.out.println(s1.hashCode()+"-----"+s2.hashCode());
		System.out.println(System.identityHashCode(s1)+"-----"+System.identityHashCode(s2));
		String s3="wangzhao";
		String s4="wangzhao";
		System.out.println(System.identityHashCode(s3)+"-----"+System.identityHashCode(s4));
	}
}
