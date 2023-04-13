
public class Cliente extends Thread{
	
	private int id;
	private Recursos r;
	
	public Cliente(int id, Recursos r) {
		this.id = id;
		this.r = r;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("<<Cliente " + id + ">>: aguardando na fila");
				r.aguardaChamada();
				r.clienteEmbarcado();
				System.out.println("<<Cliente " + id + ">>: embarcado");
				// Passeio
				r.aguardaRetirada();
				System.out.println("<<Cliente " + id + ">>: desembarcando");
				r.clienteDesembarcado();
				System.out.println("<<Cliente " + id + ">>: desembarcado");
			}
		}
		catch (InterruptedException e) {}
	}

}
