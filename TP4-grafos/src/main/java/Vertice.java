import java.util.ArrayList;
import java.util.Iterator;

public class Vertice<T> implements Comparable<Vertice>{
    private int id;
    private ArrayList<Arco<T>> arcos;

    public Vertice(int id) {
        this.id = id;
        this.arcos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void agregarArco(Arco<T> arco) {
        if(!arcos.contains(arco))
            arcos.add(arco);
    }

    public void eliminarArco(T arcoValor) {
        arcos.removeIf(arco -> arco.getEtiqueta() == arcoValor);
        //preguntar a profe
        /*
        // Creamos una lista temporal para almacenar los arcos que no queremos eliminar
        ArrayList<Arco> arcosTemp = new ArrayList<>();

        // Iteramos sobre la lista de arcos
        for (Arco arco : arcos) {
            // Si la etiqueta del arco es diferente a arcoValor, lo mantenemos en la lista temporal
            if (!arco.getEtiqueta().equals(arcoValor)) {
                arcosTemp.add(arco);
            }
        }

        // Limpiamos la lista original de arcos
        arcos.clear();

        // Añadimos de nuevo los arcos que no queríamos eliminar
        arcos.addAll(arcosTemp);
         */
    }
    public void eliminarArco(int arcoValorOrigen, int arcoValorDestino) {
        arcos.removeIf(arco -> arco.getVerticeOrigen() == arcoValorOrigen && arco.getVerticeDestino() == arcoValorDestino);
        /*
        for (Arco<T> arco: this.getArcos()) {
            if(arco.getVerticeOrigen() == arcoValorOrigen && arco.getVerticeDestino() == arcoValorDestino)
                arcos.remove(arco);
        }*/
        //preguntar a profe
    }

    @Override
    public int compareTo(Vertice o) {
        return Integer.compare(o.getId(), this.getId());
    }

    public ArrayList<Arco<T>> getArcos() {
        return new ArrayList<Arco<T>>(arcos);
    }

    public boolean tengoArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco: this.getArcos()) {
            if(arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2)
                return true;
        }
        return false;
    }
    public Arco<T> getArco(int verticeId1, int verticeId2) {
        return arcos.stream()
                .filter(arco -> arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2)
                .findFirst()
                .orElse(null);
        //preguntar a profe
        /*
        for (Arco arco : arcos) {
            if (arco.getVerticeOrigen().equals(verticeId1) && arco.getVerticeDestino(verticeId2)) {
                return arco;
            }
        }
        return null;
         */
    }

    public Iterator<Integer> getAdyacentes() {
        ArrayList<Integer> adyacentes = new ArrayList<>();
        for (Arco<T> arco: this.arcos) {
            adyacentes.add(arco.getVerticeDestino());
        }
        return adyacentes.iterator();
    }
}
