package ejercicio6;

import java.util.ArrayList;
import java.util.LinkedList;

public class Jardin {
    private int i;
    private int j;

    private Casilla[][] espacioDelJardin;


    public Jardin(int i, int j) {
        this.i = i;
        this.j = j;
        espacioDelJardin = new Casilla[i][j];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int fila = 0; fila < this.i; fila++) {
            for (int columna = 0; columna < this.j; columna++) {
                // Inicializa cada casilla con valores por defecto
                espacioDelJardin[fila][columna] = new Casilla(false,  fila, columna);
            }
        }
    }


    // Método para establecer por donde paso el caballo
    public void setCamino(int fila, int columna) {
        if (fila >= 0 && fila < this.i && columna >= 0 && columna < this.j) {
            espacioDelJardin[fila][columna].setPastoPisado(true);
        }
    }

    public LinkedList<Casilla> caminoPisado() {
        LinkedList<Casilla> entradasPosibles = new LinkedList<>();
        for (int fila = 0; fila < this.i; fila++){
            for (int columna = 0; columna < this.j; columna++) {
                if (espacioDelJardin[fila][columna].isPastoPisado()) {
                    entradasPosibles.add(espacioDelJardin[fila][columna]);
                }
            }
        }
        return entradasPosibles;
    }

    public LinkedList<Casilla> caballoAtilia(int filaOrigen, int columnaOrigen) {
        if (this.espacioDelJardin[filaOrigen][columnaOrigen].isPastoPisado())
            return caballoAtilia(new LinkedList<>(), new LinkedList<>(),filaOrigen,columnaOrigen );

        return null;
    }

    private LinkedList<Casilla> caballoAtilia(LinkedList<Casilla> camino,
                                              LinkedList<Casilla> current, int filaActual, int columnaActual) {

        if (current.size() == caminoPisado().size()) {
            System.out.println(camino);
            camino.addAll(current);
            return camino;
        }

        current.add(espacioDelJardin[filaActual][columnaActual]);

        if (movermeDerecha(filaActual,columnaActual) && !current.contains(espacioDelJardin[filaActual][columnaActual + 1])) {
            caballoAtilia(camino, current, filaActual, columnaActual + 1);
            current.removeLast();
        }

        if (movermeIzquierda(filaActual,columnaActual) && !current.contains(espacioDelJardin[filaActual][columnaActual - 1]) ) {
            caballoAtilia(camino, current, filaActual, columnaActual - 1);
            current.removeLast();
        }

        if (movermeAbajo(filaActual,columnaActual) && !current.contains(espacioDelJardin[filaActual + 1][columnaActual])) {
            caballoAtilia(camino, current, filaActual + 1, columnaActual);
            current.removeLast();
        }

        if (movermeArriba(filaActual,columnaActual) && !current.contains(espacioDelJardin[filaActual - 1][columnaActual])) {
            caballoAtilia(camino, current, filaActual - 1, columnaActual);
            current.removeLast();
        }

        return camino;
    }

    private boolean movermeDerecha(int fila, int columna) {
        if (columna < this.j - 1)  //corroboro que estoy dentro del rango de la matriz
            return this.espacioDelJardin[fila][columna].isPastoPisado();
        return false;
    }

    private boolean movermeIzquierda(int fila, int columna) {
        if (columna > 0)  //corroboro que estoy dentro del rango de la matriz
            return this.espacioDelJardin[fila][columna].isPastoPisado();
        return false;
    }

    private boolean movermeArriba(int fila, int columna) {
        if (fila > 0)  //corroboro que estoy dentro del rango de la matriz
            return this.espacioDelJardin[fila][columna].isPastoPisado();
        return false;
    }

    private boolean movermeAbajo(int fila, int columna) {
        if (fila < this.i - 1)  //corroboro que estoy dentro del rango de la matriz
            return this.espacioDelJardin[fila][columna].isPastoPisado();
        return false;
    }
}
