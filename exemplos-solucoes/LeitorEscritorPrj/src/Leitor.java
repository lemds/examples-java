
public class Leitor extends Thread {
	
	private Recursos r = null;
	private int id = -1;
	
	public Leitor (int id, Recursos r) {
		this.id = id;
		this.r = r;
	}
	
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Leitor fora da CS");
				Thread.sleep(100);
				r.inicioLeitura();
				System.out.println("Leitor " + id + " realizando leitura");
				Thread.sleep(10);
				r.finalLeitura();
				System.out.println("Leitor terminou leitura");
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
