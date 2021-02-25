import java.io.*;

public class TestBufferedReader{
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));
		String buffer=null;
		System.out.println("File a.txt file's content is follow:");
		while((buffer = br.readLine())!=null){
			System.out.println(buffer);
		}
	}
}