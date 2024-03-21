package practicasClase;

public class ArrayBi {
    
    public static void main(String[] args) {
        
        
        String[] espanyol = {"perro","gato","casa","coche", "arbol"};
        String[] ingles = {"dog","cat","house","car", "tree"};
        String[] rumano = {"caine","pisica","casa","masina", "pom"};

        String [][] arrayBiStrings = new String[5][3];

        //cada array de String va a ser un lenguaje: Ingles[0] , Español[1], Rumano[2]
        //cada array va a ser un conjunto de palabras
        //la composicion va a ser la traduccion de la misma palabra en su idioma

        //10 palabras:
        //perro, gato, casa, coche, arbol
        //dog, cat, house, car, tree
        //caine, pisica, casa, masina, pom

        for (int i = 0; i < arrayBiStrings.length ; i++) {

            for (int j = 0; j< arrayBiStrings[i].length ; j++) {

                if (j == 0){
                    arrayBiStrings[i][j] = espanyol[i];

                } else if ( j == 1) {
                    arrayBiStrings[i][j] = ingles[i];
                    
                } else {
                    arrayBiStrings[i][j] = rumano[i];
                }

                System.out.print(arrayBiStrings[i][j] + " ");
                
            }
            System.out.println();
        }



    }

}
