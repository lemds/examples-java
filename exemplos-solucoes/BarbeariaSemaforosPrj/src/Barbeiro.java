public class Barbeiro extends Thread {

	private Barbearia barbearia = null;
	
	public Barbeiro(Barbearia barbearia) {
		this.barbearia = barbearia;
	}
	
	@Override
	public void run() {
		while(true) {
			barbearia.aguardaClientes();
			barbearia.atendeCliente();
		}
	}

}