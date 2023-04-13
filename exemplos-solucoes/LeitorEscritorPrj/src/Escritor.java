
public class Escritor extends Thread {

	private Recursos r = null;
	private int id = -1;
	
	public Escritor (int id, Recursos r) {
		this.id = id;
		this.r = r;
	}
	
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Escritor fora da CS");
				Thread.sleep(200);
				r.inicioEscrita();
				System.out.println("Escritor " + id + " realizando escrita");
				Thread.sleep(1000);
				r.finalEscrita();
				System.out.println("Escritor terminou escrita");
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
