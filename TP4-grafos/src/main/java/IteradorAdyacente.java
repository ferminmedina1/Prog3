import java.util.Iterator;

public class IteradorAdyacente<T> implements Iterator<Integer> {
    private Iterator<Arco<T>> iteradorArco;


    public IteradorAdyacente(Iterator<Arco<T>> iteradorArco) {
        this.iteradorArco = iteradorArco;
    }

    @Override
    public boolean hasNext() {
        return iteradorArco.hasNext();
    }

    @Override
    public Integer next() {
        return iteradorArco.next().getVerticeDestino();
    }
}
