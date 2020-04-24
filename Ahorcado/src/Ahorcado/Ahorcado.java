package Ahorcado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ahorcado {
	protected int fallos;
	protected char palSepar[];
	protected int lineasAdivi;
	// array de letras ya puestas

	public Ahorcado() {
		this.fallos = 6;
		this.lineasAdivi = 0;
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opcion = 0, opcion2;
		System.out.println("Hola bienvenido al ahoracado");
		System.out.println("Elija una de las cuatro opciones");
		

		do {
			System.out.println("----------------------");
			System.out.println("| OPCIONES           |");
			System.out.println("----------------------");
			System.out.println("| 1 Instrucciones    |");
			System.out.println("| 2 Jugar            |");
			System.out.println("| 3 Diccionario      |");
			System.out.println("| 4 Salir            |");
			System.out.println("----------------------");
			System.out.println("V 1.0|  | Creadores Gabriel García Gámez y Sergio Martín Herrero");
			try {
				opcion = Integer.parseInt(br.readLine());
				switch (opcion) {// switch principal
				case 1:
					
					System.out.println("Las normas son muy sencillas tienes 6 intentos y solo puedes poner letras no se aceptan ni numeros ni espacios");
					System.out.println("No se puede repetir las letras que ya has escrito");
					break;
				/*case 2:// juego total del ahorcado
					for (int i = 0; i < palSepar.length; i++) {
						if (opcion == palSepar[i]) {
							// metodo poner letra
						}
					}
					break;*/
				case 3:
					do {//opciones ddiccionario
						System.out.println("----------------------");
						System.out.println("| OPCIONES           |");
						System.out.println("----------------------");
						System.out.println("| 1 Listar Dicc      |");
						System.out.println("| 2 Administrar Dicc |");
						System.out.println("| 3 Menú principal   |");
						System.out.println("----------------------");
						try {
							opcion2 = Integer.parseInt(br.readLine());
							switch (opcion2) {
							case 1:
								Diccionario.printDicc();
								break;
							case 2:
								System.out.println("Digame la contraseña");
								String cadena=br.readLine();
								if (cadena.equalsIgnoreCase("ahorcado")) {
									Diccionario.informacionAh();
								}
								
								break;
							default:
								break;
							}

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} while (opcion != 3);

					break;
				case 4:
					System.out.println("Gracias por jugar nuestro Ahorcado hasta la próxima");
					break;
				default:
					System.out.println("Solo se puede elegir entre las opciones del 1 al 4");
					break;
				}
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} while (opcion != 4);
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
