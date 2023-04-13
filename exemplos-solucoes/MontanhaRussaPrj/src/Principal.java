
public class Principal {

	public static void main(String[] args) {
		Recursos r = new Recursos();
		Vagao v = new Vagao(r);
		v.start();
		for(int i = 0; i < 10; i++) {
			Cliente c = new Cliente((i+1), r);
			c.start();
		}
	}

}
