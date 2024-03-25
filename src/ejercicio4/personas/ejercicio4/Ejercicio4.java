package ejercicio4.personas.ejercicio4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) throws IOException {

        // Atributos

        List<Persona> personas = new ArrayList<Persona>();
        Scanner teclado = new Scanner(System.in);
        Persona persona = null;
        char continuar = 'S';

        // pedir por pantalla tantas persobas como se quiera
        // al final de cada persona preguntar si se quiere introducir otra
        // guardar las Persona introducidas en una lista de tipo List

        System.out.println("Quieres introducir una persona? Pulse [s/N]: ");
        continuar = teclado.nextLine().toUpperCase().charAt(0);

        while (continuar == 'S') {
            persona = new Persona();
            System.out.println("Introduce DNI: ");
            persona.setDni(teclado.nextLine());

            System.out.println("Introduce nombre: ");
            persona.setNombre(teclado.nextLine());

            System.out.println("Introduce apellidos: ");
            persona.setApellidos(teclado.nextLine());

            System.out.println("Introduce edad: ");
            persona.setEdad(teclado.nextInt());
            ;
            teclado.nextLine();

            personas.add(persona);

            System.out.println("Hasta ahora has introducido " + personas.size() + " persona/s.");

            System.out.println("Quieres introducir otra persona? Pulse [s/N]: ");
            continuar = teclado.nextLine().toUpperCase().charAt(0);

        }

        // foreach
        System.out.println("Sacado del arrayList: ");
       
        for (Persona personaActual : personas) {
            System.out.println(personaActual.toString());
        }

        // Guardamos en fichero

        ObjectOutputStream escritor = null;

        try {
            escritor = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream("src//ejercicio4//cuatro.txt")));

            for (Persona personaActual : personas) {
                escritor.writeObject(personaActual);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (escritor != null) {
                escritor.close();

            }
        }
        System.out.println();
        // Leemos de fichero
        System.out.println("Sacado con el flujo de entrada");
        ObjectInputStream lector = null;
     
        try {
            lector = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream("src//ejercicio4//cuatro.txt")));

            while (true) {

                persona = (Persona) lector.readObject();
                System.out.println(persona.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
        } finally {
            if (lector != null) {
                lector.close();

            }
        }

        teclado.close();
    }

}
