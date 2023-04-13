
public class Vagao extends Thread {
	
	private Recursos r;
	
	public Vagao (Recursos r) {
		this.r = r;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("<<Vagão>>: sinalizando embarque");
				r.sinalizaEmbarque();
				System.out.println("<<Vagão>>: aguardando embarque");
				r.aguardaEmbarque();
				System.out.println("<<Vagão>>: executando passeio");
				Thread.sleep(1000);
				System.out.println("<<Vagão>>: sinalizando desembarque");
				r.sinalizaDesembarque();
				System.out.println("<<Vagão>>: aguardando desembarque");
				r.aguardaDesembarque();
			}
		}
		catch (InterruptedException e) {}
	}
	

}
