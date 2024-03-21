package practicasClase;
//crear un array de 10000 elementos de tipo Persona
//crear una lista de 10000 elementos de tipo Persona
//todas las instancias a introducir son iguales

//comparar el tiempo de insercio en cada caso 
//System.nanoTime()

import java.util.ArrayList;
import java.util.List;

public class ComparaArrayLista {

    public static void main(String[] args) {

        // Atributos
        long tIncial;
        long tFinal;
        long resultado;

        // TRABAJANDO CON ARRAY

        Persona persona = new Persona("123", "Daniel", "Fdez", 48);
        
        // crear un array de 10000 personas
        Persona[] personaArray = new Persona[10000];

        // introducir la misma persona 10000 veces

        tIncial = System.nanoTime();
        for (int i = 0; i < 10000; i++) {

            personaArray[i] = persona;
        }
        tFinal = System.nanoTime();
        resultado = tFinal - tIncial;
        System.out.println("El tiempo que tardará en RELLENAR el array es de: ");
        System.out.println(resultado + " nanosegundos");

        tIncial = System.nanoTime();
        for (int i = 0; i < 10000; i++) {

            persona = personaArray[i];
        }
        tFinal = System.nanoTime();
        resultado = tFinal - tIncial;
        System.out.println("El tiempo que tardará en ACCEDER el array es de: ");
        System.out.println(resultado + " nanosegundos");

        //TRABAJANDO CON LISTAS

        List<Persona> personas = new ArrayList<Persona>();

        tIncial = System.nanoTime();
        for (int i = 0; i < personaArray.length; i++) {
            
            personas.add(persona);
        }

        tFinal = System.nanoTime();
        resultado = tFinal - tIncial;
        System.out.println("El tiempo que tardará en RELLENAR la lista es de: ");
        System.out.println(resultado + " nanosegundos");

        tIncial = System.nanoTime();
        for (int i = 0; i < personaArray.length; i++) {
            
            personas.get(i);
        }

        tFinal = System.nanoTime();
        resultado = tFinal - tIncial;
        System.out.println("El tiempo que tardará en ACCEDER la lista es de: ");
        System.out.println(resultado + " nanosegundos");




    } // FinMain
} // Fin ComparaArrayLista

class Persona {

    // Atributos

    private String dni;
    private String nombre;
    private String apellidos;
    private int edad = 0;

    // Constructor

    public Persona(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Persona() {
        dni = null;
        nombre = null;
        apellidos = null;
        edad = -1;

    }

    // Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return ("[DNI: " + dni + " " + "Nombre: " + nombre + " " +
                "Apellidos: " + apellidos + " " + "Edad: " + edad + "]");
    }

} // Fin Clase Persona
