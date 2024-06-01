package ejercicio6;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Crear un jardín de tamaño 5x5
        Jardin jardin = new Jardin(3, 3);


        // Establecer algunas casillas como pisadas
        jardin.setCamino(0, 0);
        jardin.setCamino(0, 1);
        jardin.setCamino(0, 2);
        jardin.setCamino(1, 2);
        jardin.setCamino(2, 2);

        LinkedList<Casilla> camino = jardin.caballoAtilia(0, 0);

        System.out.println(camino);


    }
}
