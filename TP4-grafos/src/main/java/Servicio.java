import java.util.*;

public class Servicio<T> {
    private Grafo<T> grafo;
    private HashMap<Integer, Boolean> visitados;

    public Servicio(Grafo<T> grafo) {
        this.grafo = grafo;
        this.visitados = new HashMap<>();
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();
        while (verticesIterator.hasNext()) {
            visitados.put(verticesIterator.next(), false);
        }
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
            }else {
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

    public LinkedList<Integer> getLongestPath(int verticeId1, int verticeId2) {
        startService();
        LinkedList<Integer> solution = new LinkedList<>();
        LinkedList<Integer> auxList = new LinkedList<>();
        findLongestPath(verticeId1, verticeId2, auxList, solution);
        return solution;
    }

    private void findLongestPath(int verticeActual, int verticeAEncontrar,
                                LinkedList<Integer> currentPath, LinkedList<Integer> longestPath) {
        currentPath.add(verticeActual);
        visitados.put(verticeActual, true);

        if (verticeActual == verticeAEncontrar) {
            if (currentPath.size() > longestPath.size()) {
                longestPath.clear();
                longestPath.addAll(currentPath);
            }
        }
        else {
            Iterator<Integer> iteArcosVertice = grafo.obtenerAdyacentes(verticeActual);
            while (iteArcosVertice.hasNext()) {
                Integer adyacente = iteArcosVertice.next();
                if (!visitados.get(adyacente)) {
                    findLongestPath(adyacente, verticeAEncontrar, currentPath, longestPath);
                }
            }
        }

        //backtracking
        currentPath.removeLast();
        visitados.put(verticeActual, false);
    }

    public LinkedList<Integer> getAllPaths(int verticeDestino) {
        startService();
        LinkedList<Integer> allPaths = new LinkedList<>();
        Iterator<Integer> iteVertices = grafo.obtenerVertices();
        while (iteVertices.hasNext()) {
            Integer vertice = iteVertices.next();
            LinkedList<Integer> currentPath = new LinkedList<>();
            findAllPaths(verticeDestino, vertice, currentPath, allPaths);
        }
        return allPaths;
    }

    private void findAllPaths(int verticeDestino, int verticeActual, LinkedList<Integer> currentPath,
                              LinkedList<Integer> allPaths) {
        currentPath.add(verticeActual);
        visitados.put(verticeActual, true);

        if (verticeActual == verticeDestino) {
            allPaths.addAll(currentPath);
            //remuevo el verticeDestino de los caminos ya que es una irrelevancia
            if (allPaths.contains(verticeDestino)) {
                allPaths.removeLast();
            }
        }
        else {
            Iterator<Integer> iteAdyacentes = grafo.obtenerAdyacentes(verticeActual);
            while (iteAdyacentes.hasNext()) {
                Integer adyacente = iteAdyacentes.next();
                if (!visitados.get(adyacente) ) {
                    findAllPaths(verticeDestino, adyacente, currentPath, allPaths);
                }
            }
        }

        //backtracking
        currentPath.removeLast();
        visitados.put(verticeActual, false);
    }


    public LinkedList<Integer> getSmallestPath(int verticeId1, int verticeId2) {
        startService();
        LinkedList<Integer> solution = new LinkedList<>();
        LinkedList<Integer> auxList = new LinkedList<>();
        findSmallestPath(verticeId1, verticeId2, auxList, solution);
        return solution;
    }

    private void findSmallestPath(int verticeActual, int verticeAEncontrar,
                                 LinkedList<Integer> currentPath, LinkedList<Integer> smallestPath) {
        currentPath.add(verticeActual);
        visitados.put(verticeActual, true);

        if (verticeActual == verticeAEncontrar) {
            if (currentPath.size() < smallestPath.size() || smallestPath.isEmpty()) {
                smallestPath.clear();
                smallestPath.addAll(currentPath);
            }
        }
        else {
            Iterator<Integer> iteArcosVertice = grafo.obtenerAdyacentes(verticeActual);
            while (iteArcosVertice.hasNext()) {
                Integer adyacente = iteArcosVertice.next();
                if (!visitados.get(adyacente) && currentPath.size() < smallestPath.size()) { //poda
                    findSmallestPath(adyacente, verticeAEncontrar, currentPath, smallestPath);
                }
            }
        }
        //backtracking
        currentPath.removeLast();
        visitados.put(verticeActual, false);
    }
}
