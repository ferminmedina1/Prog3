
public class Puerta<T>  {

    private String habitacionOrigen;
    private String habitacionDestino;
    private T etiqueta;

    public Puerta(String habitacionOrigen, String habitacionDestino, T etiqueta) {
        this.habitacionOrigen = habitacionOrigen;
        this.habitacionDestino = habitacionDestino;
        this.etiqueta = etiqueta;
    }

    public String getHabitacionOrigen() {
        return habitacionOrigen;
    }

    public String getHabitacionDestino() {
        return habitacionDestino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String toString() {
        return "Puerta{" +
                "habitacionOrigen=" + habitacionOrigen +
                ", habitacionDestino=" + habitacionDestino +
                ", etiqueta=" + etiqueta +
                '}';
    }
}
