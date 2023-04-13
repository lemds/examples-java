
public class Principal {

	public static void main(String[] args) {
		
		Barbearia barbearia = new Barbearia(5);
		
		new Barbeiro(barbearia).start();
		
		for(int i = 1; i <= 100; i++) {
			new Cliente(i,barbearia).start();
			try {Thread.sleep(5);} catch (InterruptedException e) {}
		}
	}
	
}
