import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TestScannerFile{
	public static void main(String[] args) throws FileNotFoundException{
		//construct Scanner use File 
		Scanner sc=new Scanner(new File("a.txt"));
		System.out.println("File a.txt file's content:");
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}
}