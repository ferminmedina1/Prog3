import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        GrafoDirigido<String> grafo = new GrafoDirigido<>();
        GrafoDirigido<String> grafo2 = new GrafoDirigido<>();


        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);

        grafo2.agregarVertice(1);
        grafo2.agregarVertice(2);
        grafo2.agregarVertice(3);
        grafo2.agregarVertice(4);
        grafo2.agregarVertice(5);
        grafo2.agregarVertice(6);
        grafo2.agregarVertice(7);
        grafo2.agregarVertice(8);
        grafo2.agregarVertice(9);


        // Agregar arcos
        grafo.agregarArco(1,2,null);
        grafo.agregarArco(1,3,null);
        grafo.agregarArco(3,4,null);
        grafo.agregarArco(4,5,null);
        grafo.agregarArco(2,5,null);
        grafo.agregarArco(5,6,null);
        grafo.agregarArco(5,7,null);

        grafo2.agregarArco(1,3,null);
        grafo2.agregarArco(1,4,null);
        grafo2.agregarArco(3,2,null);
        grafo2.agregarArco(3,5,null);
        grafo2.agregarArco(5,6,null);
        grafo2.agregarArco(4,6,null);
        grafo2.agregarArco(4,7,null);
        grafo2.agregarArco(7,8,null);
        grafo2.agregarArco(8,9,null);
        grafo2.agregarArco(9,6,null);



        System.out.println();
        System.out.println("--------------------------------------GD-----------------------------------");
        System.out.println();
        System.out.println("Arcos del grafo dirigido:");
        Iterator<Arco<String>> it = grafo.obtenerArcos();
        while (it.hasNext()) {
            Arco<String> arco = it.next();
            System.out.println(arco);
        }

        Servicio<String> servicio = new Servicio<>(grafo2);

        // Realizar búsqueda en profundidad (DFS)
        //servicio.dfs();
        // Realizar búsqueda en profundidad (BFS)
        //servicio.bfs();

        LinkedList<Integer> solutionEj4 = servicio.getLongestPath(4,6);
        LinkedList<Integer> solutionEj5 = servicio.getAllPaths(6);

        System.out.println(solutionEj4);
        System.out.println(solutionEj5);





        /*

        // Probar métodos
        System.out.println("Cantidad de vértices grafo dirigido: " + grafo.cantidadVertices());
        System.out.println("Cantidad de arcos grafo dirigido: " + grafo.cantidadArcos());

        System.out.println("¿Contiene vértice 1? " + grafo.contieneVertice(1));
        System.out.println("¿Contiene arco entre 1 y 2? " + grafo.existeArco(1, 2)); //true
        System.out.println("¿Contiene arco entre 2 y 1? " + grafo.existeArco(2, 1)); //false

        System.out.println("Arco entre 1 y 2: " + grafo.obtenerArco(1, 2));

        System.out.println("Vértices adyacentes a 1:");
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(1);
        while (adyacentes.hasNext()) {
            System.out.println(adyacentes.next());
        }

        System.out.println( "existe vertice 8, 10 " + grafo.existeArco(8,10));
        System.out.println("Borrando vértice 1...");
        grafo.borrarVertice(1);

        System.out.println("Cantidad de vértices después de borrar: " + grafo.cantidadVertices());
        System.out.println("¿Contiene vértice 1 después de borrar? " + grafo.contieneVertice(1));

        System.out.println("Borrando arco entre 2 y 3...");
        grafo.borrarArco(2, 3);
        System.out.println("¿Existe arco entre 2 y 3 después de borrar? " + grafo.existeArco(2, 3));


        //Metodos del grafo no dirigido
        System.out.println();
        System.out.println("--------------------------------------GND-----------------------------------");
        System.out.println();

        GrafoNoDirigido<String> gnd = new GrafoNoDirigido<>();

        gnd.agregarVertice(1);
        gnd.agregarVertice(2);
        gnd.agregarVertice(3);
        gnd.agregarVertice(4);
        gnd.agregarArco(1, 2, null);
        gnd.agregarArco(2, 3, null);
        gnd.agregarArco(3, 1, null);
        gnd.agregarArco(3, 4, null);


        System.out.println("Cantidad de vértices: " + gnd.cantidadVertices());
        System.out.println("Cantidad de arcos: " + gnd.cantidadArcos());

        System.out.println("¿Existe arco entre 1 y 2? " + gnd.existeArco(1, 2));
        System.out.println("¿Existe arco entre 2 y 1? " + gnd.existeArco(2, 1));

        System.out.println("Arcos del grafo no dirigido:");
        Iterator<Arco<String>> iter = gnd.obtenerArcos();
        while (iter.hasNext()) {
            Arco<String> arco = iter.next();
            System.out.println(arco);
        }

        System.out.println("Arcos del grafo no dirigido VERTICE 3:");
        Iterator<Arco<String>> ite = gnd.obtenerArcos(3);
        while (ite.hasNext()) {
            Arco<String> arco = ite.next();
            System.out.println(arco);
        }

        System.out.println("Vértices adyacentes a 2:");
        Iterator<Integer> adyacentesGND = gnd.obtenerAdyacentes(2);
        while (adyacentesGND.hasNext()) {
            System.out.println(adyacentesGND.next());
        }

        gnd.borrarVertice(1);
        System.out.println("Cantidad de vértices después de borrar uno: " + gnd.cantidadVertices());
        System.out.println("Cantidad de arcos después de borrar un vértice: " + gnd.cantidadArcos());
    */

    }
}
