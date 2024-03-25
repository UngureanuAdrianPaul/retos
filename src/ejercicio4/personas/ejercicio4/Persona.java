package ejercicio4;

import java.io.Serializable;
@SuppressWarnings("rawtypes")
public class Persona implements Serializable, Comparable{

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
        "Apellidos: " + apellidos + " " + "Edad: " + edad +  "]");
    }
    
    @Override
    public int compareTo(Object object) {
        if(object.getClass() != this.getClass()) {

            return 1; //si el parametro no es una persona
        } else {
            Persona persona = (Persona) object;
            if (this.edad < persona.edad) {
                return 1; //si mi objeto es mejor
            } else if (this.edad == persona.edad) {
                return 0; //si son iguales
            } else {
                return -1; //si mi objeto es peor
            }
        }

       
    }

}
