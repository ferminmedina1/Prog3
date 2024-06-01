package ejercicio1;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
    //             ValorHabitacion     Puertas
    protected HashMap<String, LinkedList<Puerta<T>>> puertas;

    public GrafoDirigido() {
        puertas = new HashMap<>();
    }

    @Override
    public void agregarHabitacion(String habitacion) {
        if(!contieneHabitacion(habitacion)){
            puertas.put(habitacion, new LinkedList<>());
        }
    }

    @Override
    public void borrarHabitacion(String Habitacion) {
        puertas.values().forEach(puertasHabitacion -> puertasHabitacion.removeIf
                (puerta -> puerta.getHabitacionDestino().equals(Habitacion)));
        puertas.remove(Habitacion);
    }

    @Override
    public void agregarPuerta(String habitacion1, String habitacion2,T etiqueta) {
        if(!existePuerta(habitacion1,habitacion2)){
            puertas.get(habitacion1).add(new Puerta<>(habitacion1,habitacion2,etiqueta));
        }
    }

    @Override
    public void borrarPuerta(String habitacion1, String habitacion2) {
        //Complejidad O(N)
        //Traigo los puertas del habitacion1.
        for (Puerta<T> puerta : puertas.get(habitacion1)) { //Todos los puertas tiene habitacionOrigen = habitacion1
            //Pregunto a cada una de las puertas si su destino es el habitacion2
            if (puerta.getHabitacionDestino().equals(habitacion2)) {
                //si pasa eso elimino el puerta
                puertas.get(habitacion1).remove(puerta);
                return;
            }
        }
    }

    @Override
    public boolean contieneHabitacion(String habitacion) {
        //Complejidad O(1)
        return  puertas.containsKey(habitacion);
    }

    @Override
    public boolean existePuerta(String habitacion1, String habitacion2) {
        //Complejidad O(N)
        if (contieneHabitacion(habitacion1) && !(puertas.get(habitacion1).isEmpty()) ) {
            for (Puerta<T> puerta : puertas.get(habitacion1)) {
                if (puerta.getHabitacionDestino().equals(habitacion2)) {
                    //si pasa eso existe puerta
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Puerta<T> obtenerPuerta(String habitacion1, String habitacion2) {
        //complejidad O(N)

        //verificacion
        if (puertas.get(habitacion1) == null) {
            return null;
        }
        if (!puertas.get(habitacion1).isEmpty()) {
            //Complejidad O(N)
            for (Puerta<T> puerta : puertas.get(habitacion1)) {
                if (puerta.getHabitacionDestino().equals( habitacion2 )) {
                    //si pasa eso retorno el puerta
                    return puerta;
                }
            }
        }
        return null;
    }

    @Override
    public int cantidadHabitaciones() {
        return puertas.size();
    }

    @Override
    public int cantidadPuertas() {
        //Complejidad O(N)
        int cantidad = 0;
        for (LinkedList<Puerta<T>> puertasDelHabitacion: this.puertas.values()) {
            cantidad += puertasDelHabitacion.size();
        }
        return cantidad;
    }

    @Override
    public Iterator<String> obtenerHabitaciones() {
        return puertas.keySet().iterator();
    }

    @Override
    public Iterator<String> obtenerPuertasAdyacentes(String habitacion) {
        //Complejidad O(1)
        return new ItePuertaAdyacente<T>(puertas.get(habitacion).iterator());
    }

    @Override
    public Iterator<Puerta<T>> obtenerPuertas() {
        //Complejidad O(N)
        LinkedList<Puerta<T>> puertasObtenidos = new LinkedList<>(); //lista auxiliar
        for (LinkedList<Puerta<T>> puertasDelHabitacion : this.puertas.values()) {
            puertasObtenidos.addAll(puertasDelHabitacion);
        }
        return puertasObtenidos.iterator();
    }

    @Override
    public Iterator<Puerta<T>> obtenerPuerta(String habitacionId) {
        //Complejidad O(N)
        if (contieneHabitacion(habitacionId)) {
            LinkedList<Puerta<T>> puerta = puertas.get(habitacionId); //lista auxiliar
            return puerta.iterator();
        }
        return null;
    }

}
