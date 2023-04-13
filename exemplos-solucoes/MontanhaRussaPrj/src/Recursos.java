import java.util.concurrent.Semaphore;


public class Recursos {
	
	private final int CAPACIDADE = 5;
	
	private Semaphore embarcar = new Semaphore(0);
	private Semaphore embarcados = new Semaphore(0);
	private Semaphore desembarcar = new Semaphore(0);
	private Semaphore desembarcados = new Semaphore(0);
	
	public void sinalizaEmbarque() throws InterruptedException {
		for(int i = 0; i < CAPACIDADE; i++)
			embarcar.release();
	}
	
	public void sinalizaDesembarque() throws InterruptedException {
		for(int i = 0; i < CAPACIDADE; i++)
			desembarcar.release();
	}
	
	public void aguardaEmbarque() throws InterruptedException {
		for(int i = 0; i < CAPACIDADE; i++)
			embarcados.acquire();
	}
	
	public void aguardaDesembarque() throws InterruptedException {
		for(int i = 0; i < CAPACIDADE; i++)
			desembarcados.acquire();
	}
	
	public void aguardaChamada() throws InterruptedException {
		embarcar.acquire();
	}
	
	public void aguardaRetirada() throws InterruptedException {
		desembarcar.acquire();
	}
	
	public void clienteEmbarcado() throws InterruptedException {
		embarcados.release();
	}

	public void clienteDesembarcado() throws InterruptedException {
		desembarcados.release();
	}
}
