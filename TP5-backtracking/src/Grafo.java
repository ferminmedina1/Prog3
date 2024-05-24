
import java.util.Iterator;

public interface Grafo<T> {

    // Agrega un habitacion
    public void agregarHabitacion(String habitacionId);

    // Borra un habitacion
    public void borrarHabitacion(String habitacion);

    // Agrega un puerta con una etiqueta, que conecta el habitacionId1 con el habitacionId2
    public void agregarPuerta(String habitacion1, String habitacion2, T etiqueta);

    // Borra el puerta que conecta el habitacionId1 con el habitacionId2
    public void borrarPuerta(String habitacion1, String habitacion2);

    // Verifica si existe un habitacion
    public boolean contieneHabitacion(String habitacion);

    // Verifica si existe un puerta entre dos habitacions
    public boolean existePuerta(String habitacion1, String habitacion2);

    // Obtener el puerta que conecta el habitacionId1 con el habitacionId2
    public Puerta<T> obtenerPuerta(String habitacion1, String habitacion2);

    // Devuelve la cantidad total de habitacions en el grafo
    public int cantidadHabitaciones();

    // Devuelve la cantidad total de puertas en el grafo
    public int cantidadPuertas();

    // Obtiene un iterador que me permite recorrer todos los habitacions almacenados en el grafo
    public Iterator<String> obtenerHabitaciones();

    // Obtiene un iterador que me permite recorrer todos los habitacions adyacentes a habitacionId
    public Iterator<String> obtenerPuertasAdyacentes(String habitacion);

    // Obtiene un iterador que me permite recorrer todos los puertas del grafo
    public Iterator<Puerta<T>> obtenerPuertas();

    // Obtiene un iterador que me permite recorrer todos los puertas que parten desde habitacionId
    public Iterator<Puerta<T>> obtenerPuerta(String habitacion);
}
