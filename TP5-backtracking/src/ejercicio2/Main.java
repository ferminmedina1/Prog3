package ejercicio2;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
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
    }
}
