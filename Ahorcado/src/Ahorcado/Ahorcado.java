package Ahorcado;

public class Ahorcado {
	protected int fallos;
	protected char palSepar[];

	protected int lineasAdivi;
	// array de letras ya puestas

	public Ahorcado() {
		this.fallos=6;
		this.lineasAdivi=0;
	}

	public int getFallos() {
		return fallos;
	}

	public void setFallos(int fallos) {
		this.fallos = fallos;
	}

	public char[] getPalSepar() {
		return palSepar;
	}

	public void setPalSepar(char[] palSepar) {
		this.palSepar = palSepar;
	}

	public int getLineasAdivi() {
		return lineasAdivi;
	}

	public void setLineasAdivi(int lineasAdivi) {
		this.lineasAdivi = lineasAdivi;
	}

	public void inicioAhorcado() {
		fallos = 6;
		char opcion = 0;
		do {

			for (int i = 0; i < palSepar.length; i++) {
				if (opcion == palSepar[i]) {
					// metodo poner letra
				}
			}

		} while (true);
	}

	public int separarPal(String palabra) {
		char palSepar[] = palabra.toCharArray();

		this.lineasAdivi = palSepar.length;
		
		return lineasAdivi;
	}

	public void printLine(int lisenasAdivi) {
		for (int i = 0; i < lineasAdivi; i++) {
			System.out.print("| _ |");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
