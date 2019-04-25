import java.util.Scanner;

public class ScannerKeyBoardTest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			System.out.println("your input from keyboard is :"+sc.next());
		}
	}
}
