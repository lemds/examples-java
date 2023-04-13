
public class Main {

	public static void main(String[] args) {
		Recursos r = new Recursos();
		for (int i = 1; i <= 5; i++)
			new Leitor(i,r).start();
		for (int i = 1; i <= 2; i++)
			new Escritor(i,r).start();
	}

}
