
public class Cliente extends Thread {

	private Barbearia barbearia = null;
	private int id = 0;
	
	public Cliente(int id, Barbearia barbearia) {
		this.id = id;
		this.barbearia = barbearia;
	}
	
	@Override
	public void run() {
		if(barbearia.entraBarbearia(id)) {
			barbearia.cortaCabelo(id);
			System.out.println("Cliente " + id + " saiu da barbearia");
		}
		else
			System.out.println("Não há lugar; cliente " + id + " vai embora");
	}

}