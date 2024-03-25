package ejercicio4.personas.ejercicio4;
//crear un array de 1000 Persona

import java.io.BufferedInputStream;

//Introducir la misma persona pero con edad consecutiva y empieza en 0
//crear un directorio "personas"
//crear archivo en directorio "personas" llamado "personasIncial.dat"
//almacenar en dicho archivo todas las personas
//crear dos arcvios "personasPar.dat" y "personasImpar.dat"
//leer personas de personaIncial.dat y almacenar dependiendo del dni en uno u otro
//el que corresponda

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejer4Nuestro {

    public static void main(String[] args) throws IOException {
        Persona persona;
        Persona[] personas = new Persona[1000];

        for (int i = 0; i < personas.length; i++) {
            persona = new Persona("123", "Daniel", "Fdez", i);
            personas[i] = persona;
        }

        // mostrar directorio actual
        System.out.println(System.getProperty("user.dir"));

        // cambiar directorio a "ejercicio4" y llamarlo "personas"

        String directorio = "C://Users//Adri//Desktop//VSC//retoUD5//src//ejercicio4";
        File nuevoDirectorio = new File(directorio + "//personas");
        nuevoDirectorio.mkdir();

        // Crear un fichero personaInicial.dat

        File fichero = new File(nuevoDirectorio.getAbsolutePath() + "//personaIncial.dat");

        if (fichero.exists()) {
            System.out.println("El fichero " + fichero.getName() + " ya existe.");
        } else {
            fichero.createNewFile();
        }

        // FLUJO DE SALIDA (escribir en fichero)

        ObjectOutputStream escritor = null;

        try {
            escritor = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)));
            for (int i = 0; i < personas.length; i++) {
                escritor.writeObject(personas[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (escritor != null) {
                escritor.close();
            }
        }

        // Ficheros Par e Impar

        File personaPar = new File(directorio + "//personas//personaPar.dat");
        personaPar.createNewFile();

        File personaImpar = new File(directorio + "//personas//personaImpar.dat");
        personaImpar.createNewFile();

        // FLUJO DE ENTRADA Y SALIDA(leer de archivo Incial y escribir en el par e
        // impar)

        ObjectInputStream lector = null;
        ObjectOutputStream escritorPar = null;
        ObjectOutputStream escritorImpar = null;
        int contPar = 0;
        int contImpar = 0;
        try {

            lector = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero.getAbsolutePath())));
            escritorPar = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream(personaPar.getAbsolutePath())));
            escritorImpar = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream(personaImpar.getAbsolutePath())));

            while (true) {
                persona = (Persona) lector.readObject();
                if (persona.getEdad() % 2 == 0) {
                    escritorPar.writeObject(persona);
                    contPar++;

                } else {
                    escritorImpar.writeObject(persona);
                    contImpar++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lector != null) {
                lector.close();
            }
            if (escritorPar != null) {
                escritorPar.close();
            }
            if (escritorImpar != null) {
                escritorImpar.close();
            }

        }
        System.out.println("Hay un total de " + contPar + " elementos pares");
        System.out.println("Hay un total de " + contImpar + " elementos impares");

        // Mostrar verdaderamente los elementos introducidos en personaInicial.dat

        try {
            lector = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero.getAbsolutePath())));
            for (int i = 0; i < personas.length; i++) {
                persona = (Persona) lector.readObject();
                System.out.print(persona.getEdad() + " ");
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lector != null) {
                lector.close();

            }

        }

        // Comparar edades con el fichero original

        ObjectInputStream lector1 = null;
        ObjectInputStream lectorPar = null;
        ObjectInputStream lectorImpar = null;
        boolean correcto = true;
        try {
            lector1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)));
            lectorPar = new ObjectInputStream(new BufferedInputStream(new FileInputStream(personaPar)));
            lectorImpar = new ObjectInputStream(new BufferedInputStream(new FileInputStream(personaImpar)));

           

            while (true) {
                persona = (Persona) lector.readObject();
                if (persona.getEdad()%2 ==0) {
                    if ((persona.getEdad()) != ((Persona) lectorPar.readObject()).getEdad()) {
                        correcto = false;
                    } 
                } else {
                    if ((persona.getEdad() != ((Persona) (lectorImpar.readObject())).getEdad())) {
                        correcto = false; 
                }
            }
        }
         } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lector1 != null) {
                lector1.close();
            }
            if (lectorPar != null) {
                lectorPar.close();
            }
            if (lectorImpar != null) {
                lectorImpar.close();
            }

        }

        System.out.println("Las edades coinciden en cada nuevo fichero?");
        System.out.println(correcto);

    }
}
