package biblioteca;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		Archivo archivo = new Archivo();

		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion; // Guardaremos la opcion del usuario
		String texto;
		String codigo;
		int anyo = 0;
		ArrayList<Libro> listaLibros = new ArrayList<>();
		ArrayList<Revista> ListaRevistas = new ArrayList<>();
		while (!salir) {
			Libro libro1 = new Libro(null, null, anyo);
			System.out.println("Que operacion desea realizar");
			System.out.println("1. Añadir un nuevo libro");
			System.out.println("2. Añadir una  nueva revista");
			System.out.println("3. Coger o devoelver libro");
			System.out.println("4. Salir");

			try {

				System.out.println("Escribe una de las opciones");
				opcion = sn.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Has seleccionado añadir un nuevo libro");

					System.out.println("Escribe el codigo del libro");
					codigo = sn.next().toUpperCase();
					libro1.setCodigo(codigo);
					System.out.println("Escribe el titulo del libro");
					String saltoDeLinea = sn.nextLine();
					texto = sn.nextLine().toUpperCase();
					libro1.setTitulo(texto);
					System.out.println("Escribe el año en el que se escribio el libro");
					anyo = sn.nextInt();
					libro1.setAnio(anyo);
					System.out.println(libro1.toString());
					archivo.writeFile(libro1.toString());
					listaLibros.add(libro1);
					System.out.println(listaLibros.get(0).getCodigo());
					break;
				case 2:
					System.out.println("Has seleccionado añadir una nueva revista");
					Revista revista1 = new Revista(null, null, anyo, anyo);
					System.out.println("Escribe el codigo de la revista");
					codigo = sn.next().toUpperCase();
					revista1.setCodigo(codigo);
					System.out.println("Escribe el titulo de la revista");
					saltoDeLinea = sn.nextLine().toUpperCase();
					texto = sn.nextLine();
					revista1.setTitulo(texto);
					System.out.println("Escribe el año en el que se escribio la revista");
					anyo = sn.nextInt();
					revista1.setAnio(anyo);
					System.out.println("Escribe el numero de la revista");
					int numero = sn.nextInt();
					revista1.setNumero(numero);
					System.out.println(revista1.toString());

					archivo.writeFile(revista1.toString());
					ListaRevistas.add(revista1);

					break;
				case 3:
					System.out.println("Coger o devolver un libro");
					boolean salir1 = false;
					String opcion1;
					while (!salir1) {

						System.out.println("Que opcion desea realizar");
						try {
							System.out.println("Escribe una de las opciones");
							opcion1 = sn.next().toUpperCase();
							switch (opcion1) {
							case "DEVOLVER":
								libro1.devolver();
								System.out.println("Escribe el titulo del libro");
								saltoDeLinea = sn.nextLine();
								texto = sn.nextLine().toUpperCase();
								libro1.setTitulo(texto);
								archivo.writeFile(libro1.toString());
								listaLibros.add(libro1);
								salir1 = true;
								break;
							case "COGER":
								for (int i = 0; i < listaLibros.size(); i++) {
									System.out.println(listaLibros.get(i).getTitulo());
								}
								int numeroLibro;
								numeroLibro = sn.nextInt();
								System.out.print(listaLibros.get(numeroLibro).getTitulo());
								libro1.prestar();
								salir1 = true;
								break;
							default:
								System.out.println("Escribe la palabra completa");
							}
						} catch (InputMismatchException e) {
							System.out.println("Debes escribir la palabra completa");
							sn.next();
						}
					}
					break;
				case 4:
					salir = true;
					break;
				default:
					System.out.println("Solo números entre 1 y 4");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}
		}
	}

}