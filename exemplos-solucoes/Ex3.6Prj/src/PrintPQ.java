import java.util.concurrent.Semaphore;


public class PrintPQ extends Thread {
	
	private char toPrint;
	private Semaphore printPerm;
	
	public PrintPQ(char toPrint, Semaphore printPerm) {
		this.toPrint = toPrint;
		this.printPerm = printPerm;
	}
	
	@Override
	public void run() {
		int count = 0;
		while(true) {
			System.out.println(toPrint + " (" + ++count + ")");
			printPerm.release();
			try {Thread.sleep(100);} catch (InterruptedException e) {}
		}
	}

}
