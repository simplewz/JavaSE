package thread;

public class PrintThread implements Runnable{
	
	private char printChar;

	public PrintThread() {
		super();
	}

	public PrintThread(char printChar) {
		super();
		this.printChar = printChar;
	}

	@Override
	public void run() {
		System.out.println(printChar);
	}

	public char getPrintChar() {
		return printChar;
	}

	public void setPrintChar(char printChar) {
		this.printChar = printChar;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread printA=new Thread(new PrintThread('A'), "PrintAThread");
		Thread printB=new Thread(new PrintThread('B'), "PrintBThread");
		Thread printC=new Thread(new PrintThread('C'), "PrintCThread");
		printA.start();
		printB.start();
		printC.start();
		
		while(true) {
			printA.join();
			printB.join();
			printC.join();
		}
	}
}
