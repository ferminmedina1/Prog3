import java.util.*;

public class GrafoDirigido<T> implements Grafo<T>{
    private HashMap<Integer, Vertice<T>> vertices; // Lista de adyacencias: cada índice representa un vértice y contiene un conjunto de vértices adyacentes

    public GrafoDirigido() {
        vertices = new HashMap<Integer, Vertice<T>>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if(!contieneVertice(verticeId)){
            vertices.put(verticeId, new Vertice<T>(verticeId));
        }//preguntar a profe
        /*
        boolean encontrado = false;
        for (Vertice<T> vertice : vertices) {
            if (vertice.getId() == verticeId) {
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            vertices.add(new Vertice<T>(verticeId));
        }*/
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (vertices.get(verticeId) != null)
            vertices.remove(verticeId);
    }

    @Override
    public void agregarArco(int verticeOrigen, int verticeDestino,T etiqueta) {
        if(!existeArco(verticeOrigen,verticeDestino)){
            Vertice<T> v1 = vertices.get(verticeOrigen);
            Vertice<T> v2 = vertices.get(verticeDestino);
            if(v1 != null && v2 != null){
                v1.agregarArco(new Arco<T>(verticeOrigen, verticeDestino, etiqueta));
                //en un grafo no dirigido esto cambia
            }
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        vertices.get(verticeId1).eliminarArco(verticeId1,verticeId2);
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return  vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        Vertice<T> v1 = vertices.get(verticeId1);
        Vertice<T> v2 = vertices.get(verticeId2);
        if (v1 != null && v2 != null)
            return v1.tengoArco(verticeId1, verticeId2);
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        return vertices.get(verticeId1).getArco(verticeId1,verticeId2);
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int cantidad = 0;
        for (Vertice<T> vertice: vertices.values()) {
            cantidad += vertice.getArcos().size();
        }
        return cantidad;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        Vertice<T> verticePrincipal = vertices.get(verticeId);
        if(verticePrincipal != null)
            return vertices.get(verticeId).getAdyacentes();
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        // TODO Auto-generated method stub
        return null;
    }
}
