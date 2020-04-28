package Ahorcado;


public class Comprobaciones {
	
	
	
	
	public static void comprobarNumero(char letra) throws falloLetra {
		
		if ((letra>=48&&letra<=57)) {
			throw new falloLetra();
		}
	}
	
	
}
