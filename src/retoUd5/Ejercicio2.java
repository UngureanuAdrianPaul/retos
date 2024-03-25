package retoUd5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

                if (!nombre.equals("-")) {
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

        // Leer de uno.txt y sacarlo por pantalla y a la vez guardarlo en dos.txt

        BufferedReader lector = null;
        escritor = null;
        try {
            lector = new BufferedReader(new FileReader("dirEjer2//uno.txt"));
            escritor = new BufferedWriter(new FileWriter("dirEjer2//dos.txt"));

            nombre = lector.readLine();

            while (nombre != null) {
                System.out.println(lector + "\n");
                escritor.write(nombre + "\n");
                nombre = lector.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally { 
            if (lector != null) {
                lector.close();
            }
            if (escritor != null) {
                escritor.close();
            }
        }

    }
}
