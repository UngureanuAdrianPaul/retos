package ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) throws IOException {
        System.out.println();
        puntoA();
        puntoBC();

    }

    public static void puntoA() throws IOException {
        // mostrar directorio actual
        System.out.println(System.getProperty("user.dir"));

        // crear directorio: dirEjer2 (comprobar que existe)

        File directorio = new File("dirEjer2");

        if (directorio.exists()) {

            System.out.println("El directorio ya existe.");
        } else {
            directorio.mkdir();
        }

        // Crear dos ficheros uno.txt y dos.txt (comporbar que existe)

        File fileUno = new File("dirEjer2//uno.txt");
        File fileDos = new File("dirEjer2//dos.txt");

        if (fileUno.exists()) {
            System.out.println("El fichero " + fileUno.getName() + " ya existe.");
        } else {
            fileUno.createNewFile();
        }

        if (fileDos.exists()) {
            System.out.println("El fichero " + fileDos.getName() + " ya existe.");
        } else {
            fileDos.createNewFile();
        }

        // Escritura en fichero

    }

    public static void puntoBC() throws IOException {

        // Pedir nombres hasta que el introducido sea solo: "-"
        String nombre;
        Scanner teclado = new Scanner(System.in);
        BufferedWriter escritor = null;

        try {
            escritor = new BufferedWriter(new FileWriter(new File("dirEjer2//uno.txt"), true));
            do {
                System.out.println("Introduce nombre por pantalla");
                System.out.println("Introduce - para finalizar");
                nombre = teclado.nextLine();

                if(!nombre.equals("-")) {
                    escritor.write(nombre + "\n");
                }
            } while (!nombre.equals("-"));
            escritor.write(nombre + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {
            if (escritor != null) {
                escritor.close();
            }
        }

        teclado.close();

        // Escritura en fichero

    }
}
