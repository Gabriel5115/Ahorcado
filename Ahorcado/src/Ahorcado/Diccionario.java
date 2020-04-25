package Ahorcado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Diccionario extends Ahorcado {

	protected static String palabras[];
	protected static String palabra;
	
	
	public Diccionario() {
		this.palabra="nombre";
	}
	
	public Diccionario(String palabra) {
		this.palabra=palabra;
	}
	
	public String[] getPalabras() {
		return palabras;
	}

	public void setPalabras(String[] palabras) {
		this.palabras = palabras;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public static void informacionAh() throws IOException {
		Scanner lector = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new FileWriter("diccionario", true));
		String frase;
		do {
			System.out.println("Dime una palabra");
			frase = lector.nextLine();
			if (!frase.equals("fin")) {
				pw.println(frase);
			}
		} while (!frase.equals("fin"));
		pw.close();

	}

	public static String[] leerDicc() {
		BufferedReader bf;
		String cadena;
		int h = 0, cont = 0, num = 0, i=0;
		String [] palabras = new String[20];
		System.out.println("Leyendo fichero....");
		try {
			bf = new BufferedReader(new FileReader("Diccionario"));
			do {
				cadena = bf.readLine();
				if (cadena != null) {
					cont++;
					
				}
			} while (cadena != null);
			bf.close();
			palabras = new String[cont];
			bf = new BufferedReader(new FileReader("Diccionario"));
			do {
				cadena = bf.readLine();
				if (cadena != null) {
					palabras[i]=cadena;
					i++;
					
				}
			} while (cadena != null);
			bf.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return palabras;
	        
	}

	public static void printDicc() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Diccionario"));
			String cadena;
			System.out.println("Leyendo diccionario...");

			cadena=br.readLine();
			do {

				cadena = br.readLine();
				if (cadena != null) {
					System.out.println(cadena);
				}
			} while (cadena != null);
			System.out.println("------Fin del archivo-----");
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
