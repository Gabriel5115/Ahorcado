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
	
	protected String palabras[];
	protected String palabra;

	
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
		PrintWriter pw=new PrintWriter(new FileWriter("diccionario", true));
		String frase;
		do {
			System.out.println("Dime una frase");
			frase=lector.nextLine();
			if (!frase.equals("fin")) {
				pw.println(frase);
			}
		} while (!frase.equals("fin"));
		pw.close();
		
	}
	
	
	
	public String leerDicc() {
		
		BufferedReader bf;
		String cadena="";
		int h=0,cont=0,num=0;
		System.out.println("Leyendo fichero....");
		try {
			bf = new BufferedReader(new FileReader("diccionario"));
			do {
				cadena=bf.readLine();
				if (cadena!=null || cadena!="-") {
					cont++;
				}
			} while (cadena !=null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		palabras= new String[cont];
		for (int i = 0; i < palabras.length; i++) {
			palabras[i]=cadena;
		}
		
		
		num=(int) (Math.random()*cont);
		palabra=palabras[num];
		return palabra;
	}
	
	
	public void printDicc() {
		
		
	}
	
	
	
}
