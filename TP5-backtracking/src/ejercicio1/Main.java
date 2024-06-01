package ejercicio1;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 1

        GrafoDirigido<String>  grafo = new GrafoDirigido<>();

        grafo.agregarHabitacion("entrada");
        grafo.agregarHabitacion("living");
        grafo.agregarHabitacion("baño1");
        grafo.agregarHabitacion("patio");
        grafo.agregarHabitacion("cocina");
        grafo.agregarHabitacion("escalera");
        grafo.agregarHabitacion("pasillo_superior");
        grafo.agregarHabitacion("escalera_emergencia");
        grafo.agregarHabitacion("habitacion1");
        grafo.agregarHabitacion("baño2");
        grafo.agregarHabitacion("balcon1");
        grafo.agregarHabitacion("gimnasio");
        grafo.agregarHabitacion("habitacion2");
        grafo.agregarHabitacion("balcon2");
        grafo.agregarHabitacion("salida");

        grafo.agregarPuerta("entrada", "living", null);
        grafo.agregarPuerta("living", "baño1", null);
        grafo.agregarPuerta("living", "patio", null);
        grafo.agregarPuerta("living", "cocina", null);
        grafo.agregarPuerta("cocina", "patio", null);
        grafo.agregarPuerta("patio", "salida", null);
        grafo.agregarPuerta("entrada", "escalera", null);
        grafo.agregarPuerta("escalera", "habitacion1", null);
        grafo.agregarPuerta("habitacion1", "baño2", null);
        grafo.agregarPuerta("habitacion1", "gimnasio", null);
        grafo.agregarPuerta("habitacion1", "balcon1", null);
        grafo.agregarPuerta("gimnasio", "escalera_emergencia", null);
        grafo.agregarPuerta("escalera_emergencia", "salida", null);
        grafo.agregarPuerta("escalera", "pasillo_superior", null);
        grafo.agregarPuerta("pasillo_superior", "habitacion1", null);
        grafo.agregarPuerta("pasillo_superior", "habitacion2", null);
        grafo.agregarPuerta("pasillo_superior", "escalera_emergencia", null);
        grafo.agregarPuerta("escalera", "habitacion2", null);
        grafo.agregarPuerta("habitacion2", "balcon2", null);


        Servicio<String> servicio = new Servicio<>(grafo);

        System.out.println(servicio.getLongestPath("entrada", "salida"));
    }
}
