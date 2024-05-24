import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /*

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

*/
        //Ejercicio 2

        Laberinto laberinto = new Laberinto(4, 4);
        laberinto.setCasilla(0, 0, new Casilla(4, false, true, true, false));
        laberinto.setCasilla(0, 1, new Casilla(2, false, true, true, true));
        laberinto.setCasilla(0, 2, new Casilla(80, false, true, true, true));
        laberinto.setCasilla(0, 3, new Casilla(23, false, true, false, true));
        laberinto.setCasilla(1, 0, new Casilla(22, true, true, true, false));
        laberinto.setCasilla(1, 1, new Casilla(1, true, true, true, true));
        laberinto.setCasilla(1, 2, new Casilla(3, true, true, false, true));
        laberinto.setCasilla(1, 3, new Casilla(13, true, true, false, true));
        laberinto.setCasilla(2, 0, new Casilla(17, true, true, true, false));
        laberinto.setCasilla(2, 1, new Casilla(18, true, true, true, true));
        laberinto.setCasilla(2, 2, new Casilla(10, true, true, true, true));
        laberinto.setCasilla(2, 3, new Casilla(85, true, true, false, true));
        laberinto.setCasilla(3, 0, new Casilla(11, true, false, true, false));
        laberinto.setCasilla(3, 1, new Casilla(24, true, false, true, true));
        laberinto.setCasilla(3, 2, new Casilla(6, true, false, true, true));
        laberinto.setCasilla(3, 3, new Casilla(14, true, false, true, true));

        LinkedList<Casilla> longitudMinima = laberinto.getLongitudMinima(0, 0, 3, 3);
        System.out.println("La longitud mínima del camino es: " + longitudMinima);

    /*
        //Ejercicio 3
        /*
        SumaSubconjuntos conjuntos = new SumaSubconjuntos();

        conjuntos.addNumeros(1);
        conjuntos.addNumeros(2);
        conjuntos.addNumeros(3);
        conjuntos.addNumeros(4);



        System.out.println(conjuntos.sumSubconjuntos(5));

        //Ejercicio 4

        System.out.println(conjuntos.equalsSumPartition());


         */
    }
}
