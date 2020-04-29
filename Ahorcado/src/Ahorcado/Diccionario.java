package Ahorcado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Diccionario {

	public static void informacionAh() {
		PrintWriter pw;
		String frase;
		boolean fail=true;
		do {
		try {
			Scanner lector = new Scanner(System.in);
			pw = new PrintWriter(new FileWriter("Diccionario", true));
		
			
		
			do {
				fail=true;
				System.out.println("Introduce una palabra (introduce 'salida' para salir)");
				frase = lector.nextLine();
				Comprobaciones.checkSal(frase);
				if (!frase.equals("salida")) {
					
					pw.println(frase);
				}
			} while (!frase.equals("salida"));
			pw.close();
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		} catch (falloLetra e) {
			fail=false;
			System.err.println(e.getMessage());
			System.err.println("No se admiten numeros, solo palabras");
		}
		} while (fail==false);
	}

	public static String[] leerDicc() {
		
		BufferedReader bf;
		String cadena;
		int cont = 0, i = 0;
		boolean fail = true;
		String[] palabras = new String[100];
		File fichero = new File("Diccionario");
		do {
			if (!fichero.exists()) {
				fichero =new File("Diccionario");
				System.out.println("-------Creando fichero nuevo-------");
				try {
					fichero.createNewFile();
					informacionAh();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				bf = new BufferedReader(new FileReader("Diccionario"));
				fail = true;
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
						palabras[i] = cadena;
						i++;

					}
				} while (cadena != null);
				bf.close();

			} catch (FileNotFoundException e) {
				fail=false;
				System.err .println("Error, No se encuentra el archivo");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
		} while (fail == false);
		return palabras;

	}
	
	

	public static void printDicc() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Diccionario"));
			String cadena;
			System.out.println("Leyendo diccionario...");

			
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
