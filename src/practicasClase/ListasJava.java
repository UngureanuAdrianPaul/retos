package practicasClase;

import java.util.List;

public class ListasJava {
    public static void main(String[] args) {
        ListaInt miLista = new ListaInt("miLista");
        
    }
}

class NodoListaInt {
    // Atributos

    public int numero;  //Dato del nodo
    public NodoListaInt sig;

    // Constructor

    public NodoListaInt(int num, NodoListaInt nodoSig) {
        this.numero = num;
        this.sig = nodoSig;

    }

    //Metodos
    public void add (NodoListaInt nodo) {
        if(this.sig == null) {
            this.sig = nodo;
        } else {
            this.sig.add(nodo);
        }
    }

}

class ListaInt {

    // Atributos
    public String nombre;
    public NodoListaInt inicio;

    // Constructor
    public ListaInt(String nombre) {
        this.inicio = null;
        this.nombre = nombre;
    }

    // Metodos
    public void insertar(int num) {
        NodoListaInt nuevoNodo = new NodoListaInt(num, null);
        if(inicio == null) {
            inicio = nuevoNodo;
        } else {
            if (inicio.sig == null) {
                 inicio.sig.add(nuevoNodo);
            }
        }

    }
}
