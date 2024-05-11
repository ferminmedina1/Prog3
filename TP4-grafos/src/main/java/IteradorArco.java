import java.util.Iterator;
import java.util.LinkedList;

public class IteradorArco<T> implements Iterator<Integer> {
    private Iterator<Arco<T>> iterador;

    public IteradorArco(Iterator<Arco<T>> iterador) {
        this.iterador = iterador;
    }

    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }

    @Override
    public Integer next() {
        return iterador.next().getVerticeDestino();
    }
}

