package retoUd5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {

		// INTRODUCIR NOMBRE DE FICHEROS

		Scanner teclado = new Scanner(System.in);

		String nombre1;
		String nombre2;

		do {
			System.out.println("Introduce el nombre del primer fichero: ");
			nombre1 = teclado.nextLine();

		} while (nombre1.length() < 3);
		System.out.println("El nombre del primer fichero " + nombre1 + " es correcto! \n");

		do {
			System.out.println("Introduce el nombre del segundo fichero: ");
			nombre2 = teclado.nextLine();
		} while (nombre2.length() < 3);
		System.out.println("El nombre del segundo fichero " + nombre2 + " es correcto! \n");

		// MOSTRAR POR PANTALLA EL DIRECTORIO ACTUAL DE TRABAJO

		System.out.println(System.getProperty("user.dir") + "\n");

		// RUTA RELATIVA 1

		String directorioActual1 = System.getProperty("user.dir");
		String rutaCompletaFich1 = directorioActual1 + File.separator + nombre1;
		System.out.println(rutaCompletaFich1);
		File fichero1 = new File(rutaCompletaFich1);

		if (comprobarExiste(nombre1)) {
			System.out.println("El fichero " + nombre1 + " ya existe.");
		} else {
			fichero1.createNewFile();
		}

		// RUTA RELATIVA 2

		String directorioActual2 = System.getProperty("user.dir");
		String rutaCompletaFich2 = directorioActual2 + File.separator + nombre2;
		System.out.println(rutaCompletaFich2);
		File fichero2 = new File(rutaCompletaFich2);

		if (comprobarExiste(nombre2)) {
			System.out.println("El fichero " + nombre2 + " ya existe.");
		} else {
			fichero2.createNewFile();
		}

		// ESCRIBIR EN FICHERO1

		if (comprobarExiste(rutaCompletaFich1)) {
			escribirEnFichero(fichero1);
		}

		// LEER FICHERO1

		if (comprobarExiste(rutaCompletaFich1)) {
			leerDeFichero(rutaCompletaFich1);
		}

		// SACAR DATOS POR PANTALLA

		if (comprobarExiste(rutaCompletaFich1)) {
			System.out.println(fichero1.getName());
			System.out.println(fichero1.getAbsolutePath());
			System.out.println(fichero1.getParent());
			System.out.println(fichero1.length());
			System.out.println("Es directorio? " + fichero1.isDirectory());
			System.out.println();

		} else {
			System.out.println("No existe el fichero");
		}

		// DUPLICAR FICHEROS

		duplicarFicheros(fichero1, fichero2);

		// BORRAR FICHERO

		borrarFichero(fichero1);

		// MOSTRAR CONTENIDO FICHERO2

		leerDeFichero(fichero2);

		// CREAMOS DIRECTORIO NUEVO

		File directorio = new File("dirEjer1");

		if (comprobarExiste(directorio)) {
			System.out.println("Ya existe el directorio. ");

		} else {
			directorio.mkdir();
		}

		teclado.close();

	} // FINMAIN

	// METODOS

	static boolean leerDeFichero(File miFichero) throws IOException {

		FileReader entrada = null;

		try {
			entrada = new FileReader(miFichero);
			int caracter = entrada.read();
			while (caracter != -1) {
				System.out.print((char) caracter);
				caracter = entrada.read();

			}

			return true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (entrada != null) {
				entrada.close();
			}
		}
	}

	static boolean leerDeFichero(String miFichero) throws IOException {

		FileReader entrada = null;
		try {
			entrada = new FileReader(miFichero);
			int caracter = entrada.read();

			while (caracter != -1) {
				System.out.print((char) caracter);
				caracter = entrada.read();
			}

			return true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (entrada != null) {
				entrada.close();
			}
		}
	}

	static boolean escribirEnFichero(String miFichero) throws IOException {

		FileWriter salida = null;

		try {
			salida = new FileWriter(miFichero);

			for (int i = 0; i < 11; i++) {
				salida.write("" + i);
				salida.write('\n');
			}

			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (salida != null) {
				salida.close();
			}
		}
	}

	static boolean escribirEnFichero(File miFichero) throws IOException {

		FileWriter salida = null;

		try {
			salida = new FileWriter(miFichero);

			for (int i = 0; i < 11; i++) {
				salida.write("" + i);
				salida.write('\n');
			}

			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (salida != null) {
				salida.close();
			}
		}
	}

	static boolean borrarFichero(File miFichero) {

		return miFichero.delete();

	}

	static boolean borrarFichero(String miFichero) {

		File fichero = new File(miFichero);

		return fichero.delete();
	}

	static boolean comprobarExiste(File fichero) {

		return fichero.exists();
	}

	static boolean comprobarExiste(String fichero) {
		File miFichero = new File(fichero);

		return miFichero.exists();
	}

	static boolean duplicarFicheros(File origen, File destino) throws IOException {

		FileReader entrada = null;
		FileWriter salida = null;

		try {
			entrada = new FileReader(origen);
			salida = new FileWriter(destino);

			int caracter = entrada.read();

			while (caracter != -1) {
				salida.write((char) caracter);
				caracter = entrada.read();
			}

			return true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (entrada != null) {
				entrada.close();
			}

			if (salida != null) {
				salida.close();
			}
		}

	}

} // fin CLASE
