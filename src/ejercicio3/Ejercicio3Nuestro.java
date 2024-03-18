package ejercicio3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Ejercicio3Nuestro {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[3];
        String[] asig = new String[3];
        String nombre;
        for (int i = 0; i < 3; i++) {
            System.out.println("CREACION ALUMNO: " + i);
            System.out.println("Nombre: ");
            nombre = teclado.nextLine();

            for (int j = 0; j < 3; j++) {
                System.out.println("Asignatura " + j + ": ");
                asig[j] = teclado.nextLine();
            }
            alumnos[i] = new Alumno(nombre, asig);
        }

        teclado.close();

        for (int cont = 0; cont < 3; cont++) {
            System.out.println(alumnos[cont].getId());
        }
        System.out.println(Alumno.getIdActual());

        // FLUJO DE SALIDA (almacena objeto creado)

        ObjectOutputStream escritor = null;
        String pathFichero = "src//ejercicio3//tresNuestro.dat";
        try {
            escritor = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pathFichero)));
            escritor.writeObject(alumnos[0]);
            escritor.writeObject(alumnos[1]);
            escritor.writeObject(alumnos[2]);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (escritor != null) {
                escritor.close();
            }
        }
        alumnos[0] = null;
        alumnos[1] = null;
        alumnos[2] = null;
        // FLUJO DE ENTRADA (lectura de fichero)

        ObjectInputStream lector = null;

        try {

            lector = new ObjectInputStream(new BufferedInputStream(new FileInputStream(pathFichero)));
            int cont = 0;
            while (true) {
                alumnos[cont] = (Alumno) lector.readObject();
                System.out.println(alumnos[cont].getNombre());
                cont++;
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lector != null) {
                lector.close();
            }
        }
        System.out.println("***TERMINADO PROGRAMA***");
    }

}

// Clase para trabajar con ella

class Alumno implements Serializable {

    // Atributos
    private static int idActual = 0;
    private int id;
    private String nombre;

    private String[] asignaturas = new String[3];

    // Contructor

    public Alumno(String nombre, String[] asignaturas) {
        idActual++;
        this.id = idActual;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }

    // Getters y Setters

    public static int getIdActual() {
        return idActual;
    }

    public static void setIdActual(int idActual) {
        Alumno.idActual = idActual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
