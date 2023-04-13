import java.util.concurrent.Semaphore;


public class Main {

	public static void main(String[] args) {
		Semaphore printPerm = new Semaphore(0);
		new PrintR(printPerm).start();
		new PrintPQ('P', printPerm).start();
		new PrintPQ('Q', printPerm).start();
	}

}
