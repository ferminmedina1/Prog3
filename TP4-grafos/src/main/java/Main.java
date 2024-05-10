import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo = new GrafoDirigido<>();

        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        // Agregar arcos
        grafo.agregarArco(1, 2, null);
        grafo.agregarArco(1, 3, null);
        grafo.agregarArco(2, 3, null);
        grafo.agregarArco(3, 4, null);

        System.out.println("Arcos del grafo:");
        Iterator<Arco<String>> it = grafo.obtenerArcos();
        while (it.hasNext()) {
            Arco<String> arco = it.next();
            System.out.println(arco);
        }

        // Probar métodos
        System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());

        System.out.println("¿Contiene vértice 1? " + grafo.contieneVertice(1));
        System.out.println("¿Contiene arco entre 1 y 2? " + grafo.existeArco(1, 2)); //true
        System.out.println("¿Contiene arco entre 2 y 4? " + grafo.existeArco(2, 4)); //false

        System.out.println("Arco entre 1 y 2: " + grafo.obtenerArco(1, 2).toString());

        System.out.println("Vértices adyacentes a 1:");
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(1);
        while (adyacentes.hasNext()) {
            System.out.println(adyacentes.next());
        }

        System.out.println( "existe vertice 8, 10 " + grafo.existeArco(8,10));
        System.out.println("Borrando vértice 1...");


        System.out.println("Cantidad de vértices después de borrar: " + grafo.cantidadVertices());
        System.out.println("¿Contiene vértice 1 después de borrar? " + grafo.contieneVertice(1));

        System.out.println("Borrando arco entre 2 y 3...");
        grafo.borrarArco(2, 3);
        System.out.println("¿Existe arco entre 2 y 3 después de borrar? " + grafo.existeArco(2, 3));

        System.out.println( grafo.obtenerArco(3,4));


    }
}
