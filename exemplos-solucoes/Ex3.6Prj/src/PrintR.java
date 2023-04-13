import java.util.concurrent.Semaphore;


public class PrintR extends Thread {
	
	private Semaphore printPerm;
	
	public PrintR(Semaphore printPerm) {
		this.printPerm = printPerm;
	}
	
	@Override
	public void run() {
		int count = 0;
		while(true) {
			try {
				printPerm.acquire();
				System.out.println("R (" + ++count + ")");
				Thread.sleep(50);
			} catch (InterruptedException e) {}
		}
	}

}
