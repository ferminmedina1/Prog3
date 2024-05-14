import java.util.Iterator;

public class IteradorAdyacentes<T> implements Iterator<Integer> {
    private Iterator<Arco<T>> iteradorArco;


    public IteradorAdyacentes(Iterator<Arco<T>> iteradorArco) {
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
