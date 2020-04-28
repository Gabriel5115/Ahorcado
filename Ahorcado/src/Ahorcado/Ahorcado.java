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
	protected char[] letraP;// array de letras ya puestas
	protected char letra;
	protected char[] copiaSepar;
	protected char[] vacio;
	protected int victoria;

	public Ahorcado() {
		this.fallos = 6;
		this.lineasAdivi = 0;
		this.letraP = new char[10];
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

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public char[] getCopiaSepar() {
		return copiaSepar;
	}

	public void setCopiaSepar(char[] copiaSepar) {
		this.copiaSepar = copiaSepar;
	}

	public void inicioAhorcado(String[] palabras) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner lector = new Scanner(System.in);
		int opcion = 0, opcion2 = 0, cont2=0;
		
		boolean a = false;
		boolean no = true;

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
				System.out.println("Copyright (c) 2020 1º DAW \r\n" + "All Rights Reserved\r\n"
						+ "This product is protected by copyright and distributed under\r\n"
						+ "Licenses restricting copying, distribution, and decompilation.");
				try {
					opcion = Integer.parseInt(br.readLine());
					
					
					switch (opcion) {// switch principal
					case 1:
						System.out.println(
								"Las normas son muy sencillas tienes 6 intentos y solo puedes poner letras no se aceptan ni numeros ni espacios");
						System.out.println("No se puede repetir las letras que ya has escrito");
						break;

					case 2:// juego total del ahorcado
						cont2++;
						separarPal(palabras);
						printLine(lineasAdivi);
						copyPal(palSepar);
						do {
							if (ponerLetra(copiaSepar, victoria) == false) {
								fallos--;
								System.out.println(
										"Ohhhh, Has fallado... Siguelo intentando. Te quedan: " + fallos + " intentos");
								Dibujar.munecote(fallos);
							}
						} while (fallos != 0 && victoria != 1);
						if (finPartida(fallos) == true) {
							System.out.println("La palabra era: " + palabra);
							System.out.println("Lo siento has perdido, mas suerte la proxima vez!!!!");
						}
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

				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					System.err.println("No se admiten letras, solo números");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} while (opcion != 4);
		} while (finPartida(fallos) == false && opcion != 4);// final del juego

	}

	public void separarPal(String[] palabras) {

		int num = (int) (Math.random() * palabras.length);

		this.lineasAdivi = palabras[num].length();
		palabra = palabras[num];
		palSepar = palabras[num].toCharArray();

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

	public char[] copyPal(char[] palSepar) {

		this.copiaSepar = new char[palSepar.length];
		this.vacio = new char[copiaSepar.length];
		for (int i = 0; i < palSepar.length; i++) {
			this.copiaSepar[i] = palSepar[i];
		}
			for (int i = 0; i < letraP.length;i++) {
				letraP[i]=0;
			}
			this.victoria=0;
		return copiaSepar;

	}

	public boolean ponerLetra(char[] copiaSepar, int victoria) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner lector = new Scanner(System.in);
		int num = 0, cont = 0;
		boolean a = false, a2 = false, a3 = false, fail = true;
		
		String palAdivi;
		String opcion;
		
		
		System.out.println("Que opción quieres adivinar  o poner letra ");
		try {
			opcion = br.readLine();
			if (opcion.equalsIgnoreCase("Adivinar")) {
				System.out.println("Introduzca la palabra");
				palAdivi = br.readLine();
				if (palabra.equalsIgnoreCase(palAdivi)) {
					a = true;
					System.out.println("ENHORABUENA HAS ACERTADO LA PALABRA, ERES UN MAQUINOTE, SIGUE JUGANDO!!!!");
					this.victoria = 1;
					for (int i = 0; i < copiaSepar.length; i++) {
						System.out.print("| " + copiaSepar[i] + " |");
					}
				} else {
					a = false;
					System.out.println("Lo siento esa palabra no es esa");
				}
			} else {
				do {
					fail=true;
					try {

						do {
							System.out.println("Dime una letra");
							letra = (char) System.in.read();
							System.in.read();
							System.in.read();
							Comprobaciones.comprobarNumero(letra);
							a3 = false;
							for (int i = 0; i < letraP.length; i++) {
								if (letraP[i] != 0) {
									if (letraP[i] == letra) {
										a3 = true;
										System.out.println(
												"Letra ya introducida, por favor introduzca otra letra diferente");
									}
								}
							}
							for (int i = 0; i < letraP.length && a2 == false; i++) {
								if (letraP[i] == 0 && a3 == false) {
									a2 = true;
									letraP[i] = letra;
									a3 = false;
								}

							}
						} while (a2 == false && a3 == true);

					} catch (IOException e) {
						fail = false;

						System.err.println(e.getMessage());
					} catch (falloLetra e) {
						fail = false;
						System.err.println(e.getMessage());
						System.err.println("Solo puedes introducir letras no esta permitido numeros");
					}
				} while (fail == false);

				for (int i = 0; i < copiaSepar.length; i++) {
					if (letra == copiaSepar[i]) {
						vacio[i] = letra;
						a = true;
					}
				}

				for (int i = 0; i < vacio.length; i++) {
					if (vacio[i] == 0) {
						System.out.print("| _ |");
					} else {
						System.out.print("| " + vacio[i] + " |");
					}
				}
				for (int i = 0; i < vacio.length; i++) {
					if (vacio[i] != 0) {
						cont++;
					}
				}
				if (cont == vacio.length) {
					System.out.println("\n");
					this.victoria = 1;
					System.out.println("ENHORABUENA HAS ACERTADO LA PALABRA!!!!");
				}
			}
			System.out.println("\nLetras usadas");
			for (int i = 0; i < letraP.length; i++) {
				if (letraP[i] != 0) {
					System.out.print("[" + letraP[i] + "]");
				}

			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("\n");
		return a;
	}

}
