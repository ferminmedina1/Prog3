import java.util.*;

public class Servicio<T> {
    private Grafo<T> grafo;
    private HashMap<Integer, Boolean> visitados;

    public Servicio(Grafo<T> grafo) {
        this.grafo = grafo;
        this.visitados = new HashMap<>();
    }


    /*
    * Este metodo inicia el servicio. Mapea
    * el atributo hashMap 'visitados' con los valores
    * del vertice(Key) que utiliza el servicio  con su corresponidente Boolean en false (Value).
    * Ya que todavia no visito ningun vertice.
    */
    public void startService() {
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();
        while (verticesIterator.hasNext()) {
            visitados.put(verticesIterator.next(), false);
        }
    }

    /*Ejercicio 2 DFS*/

    public void dfs() {
        startService();
        Iterator<Integer> verticesIterador = grafo.obtenerVertices();

        // Recorremos todos los vértices
        while (verticesIterador.hasNext()) {
            Integer vertice = verticesIterador.next();
            if (!visitados.get(vertice))
                dfs(vertice, this.visitados);
        }
    }

    private void dfs(Integer vertice, HashMap<Integer, Boolean> visitados) {
        //si el vertice no esta visitado -> lo visitó
        if (!visitados.get(vertice)) {
            // Marcamos el vértice actual como visitado
            visitados.put(vertice, true);
            System.out.println(visitados);

            // Recorremos los arcos adyacentes del vértice actual
            Iterator<Integer> iteratorAdyacente = grafo.obtenerAdyacentes(vertice);
            while(iteratorAdyacente.hasNext()) {
                Integer arcoAdyacente = iteratorAdyacente.next();

                //verifico si tiene ciclos (EJERCICIO 3)
                if (visitados.get(arcoAdyacente)) {
                    System.out.println("tiene ciclo!!");
                }

                //llamada recursiva con el arcoAdyacente
                dfs(arcoAdyacente, visitados);
            }
        }

        System.out.println("el vertice " + vertice + " esta visitado");
    }

    /*BFS*/
    public void bfs() {
        startService();
        // Crear una cola para manejar los vértices
        Queue<Integer> cola = new LinkedList<>();
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();
        while (verticesIterator.hasNext()) {
            Integer vertice = verticesIterator.next();
            bfs(vertice,cola);
        }
    }

    private void bfs(int vertice, Queue<Integer> cola) {
        if (!visitados.get(vertice)){
            visitados.put(vertice, true);
            cola.add(vertice);

            while (!cola.isEmpty()) { //mientras la cola no este vacia
                System.out.println(cola);
                int actual = cola.poll(); // Remover y obtener el vértice al frente de la cola
                Iterator<Integer> iteradorAdyacente = grafo.obtenerAdyacentes(actual);
                while (iteradorAdyacente.hasNext()) {
                    Integer adyacente = iteradorAdyacente.next();
                    if (!visitados.get(adyacente)){
                        cola.add(adyacente); // Agregar el vértice adyacente a la cola
                        visitados.put(adyacente, true);
                    }
                }
            }
            System.out.println(visitados);
        }
    }




}
