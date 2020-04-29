package Ahorcado;


public class Comprobaciones {
	
	
	
	
	public static void comprobarNumero(char letra) throws falloLetra {
		if ((letra>=48&&letra<=57)||(letra==32)||(letra==10)||(letra==13)) {
			throw new falloLetra();
		}
	}
	
	
	public static void checkMenu(String opcion3) throws falloLetra {
		int num;
		opcion3.charAt(0);
		num=Integer.parseInt(opcion3);
		if ((num>=97&&num<=122)||(num>=65&&num<=90)||(num==32)||(num==10)||(num==13)) {
			throw new falloLetra();
		}
	}
	
	
	
	public static void checkMenu2(String opcion4) throws falloLetra {
		int num;
		opcion4.charAt(0);
		num=Integer.parseInt(opcion4);
		if ((num>=97&&num<=122)||(num>=65&&num<=90)||(num==32)||(num==10)||(num==13)) {
			throw new falloLetra();
		}
	}
	
	public static void checkSal(String frase) throws falloLetra {
		char num;
		frase.charAt(0);
		num=frase.charAt(0);
		
		if ((num>=48&&num<=57)||(num==32)||(num==10)||(num==13)) {
			throw new falloLetra();
		}
	}
	
	public static void adiviPal(String palAdivi) throws falloLetra {
		char num;
		palAdivi.charAt(0);
		num=palAdivi.charAt(0);
		
		if ((num>=48&&num<=57)||(num==32)||(num==10)||(num==13)) {
			throw new falloLetra();
		}
	}
}
