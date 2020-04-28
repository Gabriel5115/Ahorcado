package Ahorcado;

public class falloLetra extends Exception {

	

	public falloLetra() {
		super("Error");
	}
	
	public falloLetra(String mensaje) {
		super(mensaje);
	}
}
