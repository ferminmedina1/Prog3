

import java.util.Iterator;

public class ItePuertaAdyacente<T> implements Iterator<String> {
    private Iterator<Puerta<T>> iteradorPuerta;


    public ItePuertaAdyacente(Iterator<Puerta<T>> iteradorPuerta) {
        this.iteradorPuerta = iteradorPuerta;
    }

    @Override
    public boolean hasNext() {
        return iteradorPuerta.hasNext();
    }

    @Override
    public String next() {
        return iteradorPuerta.next().getHabitacionDestino();
    }
}

