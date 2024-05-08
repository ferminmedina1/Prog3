package ProgramacionIII.tp4;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, Vertice<T>> vertices;

	public GrafoDirigido() {
		vertices = new HashMap<>();
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
	/*Preguntarr*/
	public void borrarVertice(int verticeId) {
		if (vertices.get(verticeId) != null){
			for (Vertice<T> v : this.vertices.values()) {
				if (v.getListaAdyacentes().contains(verticeId)) {
					v.eliminarArco(v.getId(),verticeId);
				}
			}
			vertices.remove(verticeId);
		}

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2,T etiqueta) {
		if(!existeArco(verticeId1,verticeId2)){
			//Trae el pirmer vertice
			Vertice<T> v1 = vertices.get(verticeId1);
			//Trae el segundo vertice
			Vertice<T> v2 = vertices.get(verticeId2);
			if(v1 != null && v2 != null){
				v1.agregarArco(new Arco<T>(verticeId1, verticeId2, etiqueta));
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
			return verticePrincipal.getAdyacentes();
		return null;
	}

	/**
	 * NOTA: Iterator es una interfaz que se utiliza para recorrer elementos de una colección
	 * de manera secuencial. Permite acceder a los elementos de una colección sin exponer la
	 * estructura interna de la misma.
	 * */

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcosObtenidos = new ArrayList<>();
		for (Vertice<T> vertice :this.vertices.values()) {
			arcosObtenidos.addAll(vertice.getArcos());
		}
		return arcosObtenidos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		Vertice<T> vertice = vertices.get(verticeId);
		if (vertice!= null) {
			return vertice.getArcos().iterator();
		}
		return null;
	}
}
