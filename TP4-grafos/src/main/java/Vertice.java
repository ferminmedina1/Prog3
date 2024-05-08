
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Vertice<T> implements Comparable<Vertice<T>> {
    private int id;
    private ArrayList<Arco<T>> arcos;
    private ArrayList<Integer> valorAdyacentes;

    public Vertice(int id) {
        this.id = id;
        this.arcos = new ArrayList<>();
        this.valorAdyacentes = new ArrayList<Integer>();
    }

    public int getId() {
        return id;
    }

    public void agregarArco(Arco<T> arco) {
        if (!arcos.contains(arco)) {
            arcos.add(arco);
            if(!valorAdyacentes.contains(arco.getVerticeDestino())){
                valorAdyacentes.add(arco.getVerticeDestino());
            }
        }
    }

//Delete for Id
    public void eliminarArco(int arcoIdOrigen, int arcoIdDestino) {
        valorAdyacentes.remove( (Integer) arcoIdDestino);
        arcos.removeIf(arco -> arco.getVerticeOrigen() == arcoIdOrigen && arco.getVerticeDestino() == arcoIdDestino);
    }


    //Delete for label
    public void eliminarArco(T arcoValor) {
        arcos.removeIf(arco -> arco.getEtiqueta() == arcoValor);
    }

    @Override
    public int compareTo(Vertice o) {
        return Integer.compare(o.getId(), this.getId());
    }

    public ArrayList<Arco<T>> getArcos() {
        return new ArrayList<>(arcos);
    }

    public boolean tengoArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco : this.getArcos()) {
            if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2)
                return true;
        }
        return false;
    }

    public Arco<T> getArco(int verticeId1, int verticeId2) {
        return arcos.stream()
                .filter(arco -> arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2)
                .findFirst()
                .orElse(null);
    }

    public Iterator<Integer> getAdyacentes() {
        return new ArrayList<>(valorAdyacentes).iterator();
    }

    public ArrayList<Integer> getListaAdyacentes() {
        return new ArrayList<>(valorAdyacentes);
    }
}