package practicasClase;

import java.util.ArrayList;
import java.util.List;

public class ListaArrays {

    //una lista de palabras escritas en 3 idiomas
    // 0 Ingles
    // 1 Español
    // 2 Rumano
    
    //La lista no tiene tamaño fijo, los idiomas si tienen tamaño fijo (usar array)
    //si de una palabra no tenemos la traduccion a algun idioma se pone a null y se
    // se añadira mas adelante


    public static void main(String[] args) {
        
        String[] espanyol = {"botella", "puerta", "suelo", null ,"television"};
        String[] ingles = {"bottle",null, "floor", "wall","TV"};
        String[] rumano = {"sticla","poarta",null,"zid","televizor"};
        
        
        List<String[]> palabra = new ArrayList<String[]>();

    }
    
}
