package ejercicio2;

import java.util.LinkedList;

public class Laberinto {
    private int i;
    private int j;
    private Casilla[][] tablero;

    public Laberinto(int i, int j) {
        this.i = i;
        this.j = j;
        tablero = new Casilla[i][j];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int fila = 0; fila < this.i; fila++) {
            for (int columna = 0; columna < this.j; columna++) {
                // Inicializa cada casilla con valores por defecto
                tablero[fila][columna] = new Casilla(0, false, false, false, false);
            }
        }
    }


    // Método para establecer una casilla específica
    public void setCasilla(int fila, int columna, Casilla casilla) {
        if (fila >= 0 && fila < this.i && columna >= 0 && columna < this.j) {
            tablero[fila][columna] = casilla;
        }
    }

    public LinkedList<Casilla> getLongitudMinima(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
        return findLongitudMinima(filaOrigen, columnaOrigen, filaDestino, columnaDestino, new LinkedList<>(), new LinkedList<>());
    }

    private LinkedList<Casilla> findLongitudMinima(int filaActual, int columnaActual, int filaDestino, int columnaDestino,
                                          LinkedList<Casilla> current, LinkedList<Casilla> smallest) {

        current.add(this.tablero[filaActual][columnaActual]);

        if (this.tablero[filaActual][columnaActual] == this.tablero[filaDestino][columnaDestino]) {
            //caso base
            if (sum(current) < sum(smallest) || smallest.isEmpty()) {
                smallest.clear();
                smallest.addAll(current);
            }
            return smallest;
        }


        //todavia no llegue al destino
        if (!smallest.isEmpty() && sum(current) >= sum(smallest)) { //PODA
            System.out.println("PODA!");
            System.out.println(smallest);
            System.out.println(current);
            return current;
        }
        //explorar todas las posibilidades (moverme derecha, abajo, arriba, izquierda)
        if (movermeDerecha(filaActual, columnaActual) && !current.contains(this.tablero[filaActual ][columnaActual + 1])) {
            findLongitudMinima(filaActual, columnaActual + 1, filaDestino, columnaDestino,
                    current, smallest);
            current.removeLast();
        }

        if (movermeAbajo(filaActual,columnaActual) && !current.contains(this.tablero[filaActual + 1][columnaActual])) {
            findLongitudMinima(filaActual + 1, columnaActual, filaDestino, columnaDestino,
                    current,smallest);
            current.removeLast();
        }

        if (movermeArriba(filaActual, columnaActual) && !current.contains(this.tablero[filaActual -1 ][columnaActual])) {
            findLongitudMinima(filaActual -1, columnaActual, filaDestino, columnaDestino,
                                                current, smallest);
            current.removeLast();
        }

        if (movermeIzquierda(filaActual, columnaActual) && !current.contains(this.tablero[filaActual ][columnaActual - 1])) {
            findLongitudMinima(filaActual, columnaActual - 1, filaDestino, columnaDestino,
                    current, smallest);
            current.removeLast();
        }

      return smallest;
    }

    //funcion auxiliar para sumar
    private int sum (LinkedList<Casilla> list) {
        int sum = 0;
        for (Casilla casilla : list ) {
            sum += casilla.getValorNatural();
        }
        return sum;
    }

    private boolean movermeDerecha(int fila, int columna) {
        if (columna < this.j - 1)  //corroboro que estoy dentro del rango de la matriz
            return this.tablero[fila][columna].isEste();
        return false;
    }

    private boolean movermeIzquierda(int fila, int columna) {
        if (columna > 0)  //corroboro que estoy dentro del rango de la matriz
            return this.tablero[fila][columna].isOeste();
        return false;
    }

    private boolean movermeArriba(int fila, int columna) {
        if (fila > 0)  //corroboro que estoy dentro del rango de la matriz
            return this.tablero[fila][columna].isNorte();
        return false;
    }

    private boolean movermeAbajo(int fila, int columna) {
        if (fila < this.i - 1)  //corroboro que estoy dentro del rango de la matriz
            return this.tablero[fila][columna].isSur();
        return false;
    }

}
