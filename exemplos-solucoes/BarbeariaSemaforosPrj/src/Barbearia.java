import java.util.concurrent.Semaphore;


public class Barbearia {
	
	private volatile int MAXCLIENTES;
	private volatile int numClientes;
	
	private Semaphore barbeiro;
	private Semaphore clientes;
	private Semaphore fimAtendimento;
	private Semaphore mutex;
	
	public Barbearia(int max) {
		MAXCLIENTES = max;
		numClientes = 0;
		barbeiro = new Semaphore(0);
		clientes = new Semaphore(0);
		fimAtendimento = new Semaphore(0);
		mutex = new Semaphore(1);
	}
	
	// Métodos do barbeiro
	public void aguardaClientes() {
		System.out.println("Barbeiro aguardando clientes");
		try{barbeiro.acquire();} catch (InterruptedException e) {}
		try{mutex.acquire();} catch (InterruptedException e) {}
		System.out.println("Barbeiro acordado; chama próximo cliente");
		clientes.release();
		mutex.release();
	}
	
	public void atendeCliente() {
		System.out.println("Barbeiro atendendo cliente");
		try{Thread.sleep(20);} catch (InterruptedException e) {}
		System.out.println("Atendimento encerrado");
		try{mutex.acquire();} catch (InterruptedException e) {}
		fimAtendimento.release();
		mutex.release();
	}
	
	// Métodos do cliente
	public boolean entraBarbearia(int id) {
		boolean resultado = false;
		
		System.out.println("Cliente " + id + " entrou na barbearia");
		
		try{mutex.acquire();} catch (InterruptedException e) {}
		if(numClientes >= MAXCLIENTES)
			resultado = false; // Não há lugar
		else {
			// Acorda o barbeiro
			System.out.println("Cliente " + id + " aguardando");
			numClientes++;
			barbeiro.release();
			mutex.release();
			try{clientes.acquire();} catch (InterruptedException e) {}
			try{mutex.acquire();} catch (InterruptedException e) {}
			System.out.println("Cliente " + id + " chamado pelo barbeiro");
			numClientes--;
			resultado = true;
		}
		
		mutex.release();
		return resultado;
	}
	
	public void cortaCabelo(int id) {
		System.out.println("Cliente " + id + " cortando cabelo");
		try{fimAtendimento.acquire();} catch (InterruptedException e) {}
		System.out.println("Cliente " + id + " terminou corte");
	}

}
