package Ahorcado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Diccionario {


	public static void informacionAh() {
        PrintWriter pw;
        String frase;
        try {
            Scanner lector = new Scanner(System.in);
            pw = new PrintWriter(new FileWriter("diccionario", true));
            do {
                System.out.println("Introduce una palabra (introduce 'salida' para salir)");
                frase = lector.nextLine();
                if (!frase.equals("salida")) {
                    pw.println(frase);
                }
            } while (!frase.equals("salida"));
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

	public static String[] leerDicc() {
		BufferedReader bf;
		String cadena;
		int cont = 0, i=0;
		String [] palabras = new String[100];
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
