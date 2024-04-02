public class Cluedo {

    public static void main(String[] args) {
        
        String[] personajesArray = {"Amapola", "Celeste", "Prado", "Mora", "Rubio", "Blanco"}; //6 elementos
        String[] armasArray = {"bate", "pistola", "candelabro", "cuchillo", "cuerda", "hacha", "pesa", "veneno", "trofeo"}; //9 elementos
        String[] habitacionesArray = {"casa de invitados", "teatro", "spa", "observatorio", "comedor", "terraza", "salon", "cocina", "vestibulo"}; //9 elementos

        System.out.println("Bienvenido a Cluedo!");
        System.out.println();

        Jugador jugador1 = new Jugador();

        jugador1.setArma(armasArray[0]);
        jugador1.setNombre(personajesArray[0]);
        jugador1.setHabitacion(habitacionesArray[0]);
        jugador1.setHoraPartida();
        //Estoy en privada
        System.out.println(jugador1.toString());
    }

}
