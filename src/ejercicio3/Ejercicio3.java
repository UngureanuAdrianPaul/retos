package ejercicio3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);

        // FLUJO DE SALIDA (escribir en archivo)
        ObjectOutputStream escritor = null;

        try {
            escritor = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream("src//ejercicio3//tres.dat")));
            int num;
            num = teclado.nextInt();

            while (num > -1) {
                escritor.writeObject((Integer) num);
                num = teclado.nextInt();
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

        // FLUJO DE ENTRADA (leer de archivo)

        ObjectInputStream lector = null;

        try {
            lector = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src//ejercicio3//tres.dat")));
            int num = (int) lector.readObject();

            while (lector.available() > 1) {
                System.out.println(num);
                num = (int) lector.readObject();
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
    }
}