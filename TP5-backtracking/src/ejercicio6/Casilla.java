package ejercicio6;

public class Casilla {
    private boolean pastoPisado;
    private int posFila;
    private int posColumna;

    public Casilla(boolean pastoPisado, int posFila, int posColumna) {
        this.pastoPisado = pastoPisado;
        this.posFila = posFila;
        this.posColumna = posColumna;
    }

    public boolean isPastoPisado() {
        return pastoPisado;
    }

    public void setPastoPisado(boolean pastoPisado) {
        this.pastoPisado = pastoPisado;
    }

    @Override
    public String toString() {
        return "Casilla{" +
                "pastoPisado=" + pastoPisado +
                ", posFila=" + posFila +
                ", posColumna=" + posColumna +
                '}';
    }
}
