package ProgramacionIII.tp4;
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
        grafo.agregarArco(1, 2, "Arco 1-2");
        grafo.agregarArco(1, 3, "Arco 1-3");
        grafo.agregarArco(2, 4, "Arco 2-4");
        grafo.agregarArco(3, 4, "Arco 3-4");
        grafo.agregarArco(4, 1, "Arco 4-1");

        // Mostrar la cantidad de vértices y arcos
        System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());

        // Verificar si existe un arco entre dos vértices
        System.out.println("¿Existe arco entre 1 y 2?: " + grafo.existeArco(1, 2));
        System.out.println("¿Existe arco entre 2 y 3?: " + grafo.existeArco(2, 3));
        System.out.println("¿Existe arco entre 3 y 3?: " + grafo.existeArco(3, 4));

        // Obtener arco entre dos vértices
        Arco<String> arco = grafo.obtenerArco(1, 2);
        if (arco != null) {
            System.out.println("Arco entre 1 y 2: Origen=" + arco.getVerticeOrigen() + ", Destino=" + arco.getVerticeDestino() + ", Etiqueta=" + arco.getEtiqueta());
        } else {
            System.out.println("No existe arco entre 1 y 2.");
        }

        // Borrar un vértice
        //grafo.borrarVertice(3);
        grafo.borrarVertice(1);
        System.out.println("Cantidad de vértices después de borrar uno: " + grafo.cantidadVertices());
        System.out.println("Cantidad de vértices después de borrar uno: " + grafo.existeArco(4,1));

        // Obtener los vértices adyacentes al vértice con ID 1
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(3);
        System.out.println("Vértices adyacentes al vértice 3:");
        while (adyacentes.hasNext()) {
            int verticeAdyacente = adyacentes.next();
            System.out.println(" - " + verticeAdyacente);
        }
    }

}
