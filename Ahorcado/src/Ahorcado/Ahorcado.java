package Ahorcado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ahorcado {
	protected int fallos;
	protected char palSepar[];
	protected int lineasAdivi;
	protected String palabra;
	// array de letras ya puestas
	protected char letra;

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

	public void inicioAhorcado(String[] palabras) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner lector = new Scanner(System.in);
		int opcion = 0, opcion2;
		boolean a = false;

		System.out.println("Hola bienvenido al ahoracado");
		System.out.println("Elija una de las cuatro opciones");
		do {

			do {
				System.out.println("----------------------");
				System.out.println("| OPCIONES           |");
				System.out.println("----------------------");
				System.out.println("| 1 Instrucciones    |");
				System.out.println("| 2 Jugar            |");
				System.out.println("| 3 Diccionario      |");
				System.out.println("| 4 Salir            |");
				System.out.println("----------------------");
				System.out.println("Creadores Gabriel García Gámez y Sergio Martín Herrero  Ahorcado Clase  V 1.0 ©");
				try {
					opcion = Integer.parseInt(br.readLine());
					switch (opcion) {// switch principal
					case 1:

						System.out.println(
								"Las normas son muy sencillas tienes 6 intentos y solo puedes poner letras no se aceptan ni numeros ni espacios");
						System.out.println("No se puede repetir las letras que ya has escrito");
						break;

					case 2:// juego total del ahorcado

						separarPal(palabras);
						printLine(lineasAdivi);
						do {
							System.out.println("Digame una letra");
							letra = (char) System.in.read();
							System.in.read();
							for (int i = 0; i < palSepar.length; i++) {
								if (palSepar[i] == letra) { // metodo poner letra } } break;
									a = true;

								}
							}

							if (a == false) {
								fallos--;
								System.out.println(
										"Ohhhh, Has fallado... Siguelo intentando. Te quedan: " + fallos + " intentos");
								Dibujar.munecote(fallos);
							}
						} while (!(palabra.equalsIgnoreCase(palabra)));

						break;
					case 3:
						try {
							do {// opciones diccionario
								System.out.println("----------------------");
								System.out.println("| OPCIONES           |");
								System.out.println("----------------------");
								System.out.println("| 1 Listar Dicc      |");
								System.out.println("| 2 Administrar Dicc |");
								System.out.println("| 3 Menú principal   |");
								System.out.println("----------------------");

								opcion2 = Integer.parseInt(br.readLine());
								switch (opcion2) {
								case 1:
									Diccionario.printDicc();
									break;
								case 2:
									System.out.println("Digame la contraseña");
									String cadena = br.readLine();
									if (cadena.equalsIgnoreCase("ahorcado")) {
										Diccionario.informacionAh();
									}

									break;
								default:
									break;
								}
							} while (opcion2 != 3);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						break;
					case 4:
						System.out.println("Gracias por jugar nuestro Ahorcado hasta la próxima");
						break;
					default:
						System.out.println("Solo se puede elegir entre las opciones del 1 al 4");
						break;
					}
				} catch (NumberFormatException |

						IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} while (opcion != 4);
		} while (finPartida(fallos) == false);// final del juego

	}

	public char[] separarPal(String[] palabras) {

		int num = (int) (Math.random() * palabras.length);

		this.lineasAdivi = palabras[num].length();
		palSepar = palabras[num].toCharArray();
		return palSepar;
	}

	public void printLine(int lisenasAdivi) {
		for (int i = 0; i < lineasAdivi; i++) {
			System.out.print("| _ |");

		}
		System.out.println("\n");
	}

	public static boolean finPartida(int fallos) {
		boolean h = false;
		if (fallos == 0) {
			h = true;
		}

		return h;

	}

}
