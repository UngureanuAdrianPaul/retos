package practicasClase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

import ejercicio4.Persona;

public class ListasYconjuntos {
    public static void main(String[] args) {

        // Creamos una lista de Personas,la rellenamos de 100 Personas
        // creamos un set
        // le introducimos los elementos de la lista

        ArrayList<Persona> listaPersona = new ArrayList<Persona>();

        Persona persona;

        for (int i = 0; i < 100; i++) {
            persona = new Persona("1", "Dani", "Fdez", i);
            listaPersona.add(persona);

        }
        listaPersona.sort(null);
        System.out.println("La LISTA de Personas es: ");
        System.out.println(listaPersona);

        Set<Persona> setPersona = new HashSet<Persona>();

        for (int i = 0; i < listaPersona.size(); i++) {

            setPersona.add(listaPersona.get(i));
        }

        Iterator <Persona> iteradorSet = setPersona.iterator();

        while (iteradorSet.hasNext()) {
            System.out.println(( iteradorSet.next()).getDni());
        }

        System.out.println("El SET de Personas es: ");
        System.out.println(setPersona);

    }
}
