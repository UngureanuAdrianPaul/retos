
import java.time.LocalTime;

public class Jugador {
    
    //Atributos

    private String nombre ;
    private String habitacion;
    private String arma;
    private LocalTime horaPartida;

    //Constructor

    public Jugador() {
        this.nombre = null;
        this.habitacion = null;
        this.arma = null;
        this.horaPartida = null;
    }

    //Getters y Setters
    
   
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }
    public String getArma() {
        return arma;
    }
    public void setArma(String arma) {
        this.arma = arma;
    }
    public LocalTime getHoraPartida() {
        return horaPartida;
    }
    public void setHoraPartida() {
        this.horaPartida = LocalTime.now();
    }
  
    //TOSTRING

    public String toString(){
         
        return "[Nombre: " + nombre + " , Arma: " + arma + " , Habitacion: " + habitacion + " , Hora: " + horaPartida + "]";
    }
}
