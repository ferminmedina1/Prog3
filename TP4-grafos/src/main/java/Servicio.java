import java.util.*;

public class Servicio<T> {
    private Grafo<T> grafo;

    public Servicio(Grafo<T> grafo) {
        this.grafo = grafo;
    }

    /*Ejercicio 2 DFS*/

    public void dfs() {
        Set<Integer> visitados = new HashSet<>(); // Utilizamos un HashSet para almacenar los vértices visitados
        Iterator<Integer> verticesIterador = grafo.obtenerVertices();

        // Recorremos todos los vértices
        while (verticesIterador.hasNext()) {
            Integer vertice = verticesIterador.next();
            if (!visitados.contains(vertice)) {
                dfs(vertice, visitados);
            }
        }
    }

    private void dfs(Integer vertice, Set<Integer> visitados) {
        // Marcamos el vértice actual como visitado
        visitados.add(vertice);

        System.out.println("Visitando vértice: " + vertice);

        // Recorremos los arcos del vértice actual
        Iterator<Arco<T>> iteratorArco = grafo.obtenerArcos(vertice);
        while (iteratorArco.hasNext()) {
            Arco<T> arco = iteratorArco.next();
            Integer verticeDestino = arco.getVerticeDestino();

            // Llamamos a dfs recursivamente para los vértices adyacentes no visitados aún
            if (!visitados.contains(verticeDestino)) {
                dfs(verticeDestino, visitados);
            }
        }
    }

    /*BFS*/
    //TO-DO

}
