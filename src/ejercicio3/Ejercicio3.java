package ejercicio3;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[3];
        String[] asig = new String[3];
        String nombre;
        for (int i = 0; i < 3; i++) {
            System.out.println("CREACION ALUMNO + " + i);
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


        //FLUJO DE SALIDA

        ObjectOutputStream salida = null;

        salida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("")))
    }

}

// Clase para trabajar con ella

class Alumno {

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

}
