package Ahorcado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tester {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		
		String palabras[]=Diccionario.leerDicc();
		Ahorcado ahorcado= new Ahorcado();
		
		ahorcado.inicioAhorcado(palabras);
		
		
		
	}

}
