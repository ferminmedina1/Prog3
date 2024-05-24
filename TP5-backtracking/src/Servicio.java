
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Servicio<T> {
    private HashMap<String, Boolean> visitados;
    private Grafo<T> grafo;

    public Servicio( Grafo<T> grafo) {
        this.grafo = grafo;
        this.visitados = new HashMap<>();
        startService();
    }

    public void startService() {
        Iterator<String> habitacionesIterator = grafo.obtenerHabitaciones();
        while (habitacionesIterator.hasNext()) {
            visitados.put(habitacionesIterator.next(), false);
        }
    }

    public LinkedList<String> getLongestPath(String entrada, String salida) {
        LinkedList<String> longestPath = new LinkedList<>();
        LinkedList<String> currentPath = new LinkedList<>();
        findLongestPath(entrada, salida, longestPath, currentPath);
        return longestPath;
    }

    private void findLongestPath(String habitacionActual, String salida, LinkedList<String> longestPath,
                                 LinkedList<String> currentPath) {
        if (habitacionActual.equals(salida)) {
            if (currentPath.size() > longestPath.size()) {
                longestPath.clear();
                longestPath.addAll(currentPath);
            }
        }
        //backtracking
        else {
            visitados.put(habitacionActual, true);
            currentPath.add(habitacionActual);
            Iterator<String> itePuertaAdyacente = grafo.obtenerPuertasAdyacentes(habitacionActual);
            while (itePuertaAdyacente.hasNext()) {
                String puertaAdyacente = itePuertaAdyacente.next();
                if (!visitados.get(puertaAdyacente)) {
                    findLongestPath(puertaAdyacente, salida, longestPath, currentPath);
                }
            }
            currentPath.removeLast();
            visitados.put(habitacionActual, false);
        }
    }
}
