import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
	//             ValorVertice     Arcos
	private HashMap<Integer, ArrayList<Arco<T>>> vertices;

	public GrafoDirigido() {
		vertices = new HashMap<>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		if(!contieneVertice(verticeId)){
			vertices.put(verticeId, new ArrayList<>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		vertices.values().forEach(arcosDelVertice -> arcosDelVertice.removeIf
				(arco -> arco.getVerticeDestino() == verticeId));
		vertices.remove(verticeId);

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2,T etiqueta) {
		if(!existeArco(verticeId1,verticeId2)){
			//NOTA: etiqueta = null cambiara en un arco ponderado
			vertices.get(verticeId1).add(new Arco<>(verticeId1,verticeId2,etiqueta));
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		//Complejidad O(N)
		//Traigo los arcos del verticeId1.
		for (Arco<T> arco : vertices.get(verticeId1)) { //Todos los arcos tiene verticeOrigen = verticeId1
			//Pregunto a cada uno de los arcos si su destino es el verticeId2
			if (arco.getVerticeDestino() == verticeId2) {
				//si pasa eso elimino el arco
				vertices.get(verticeId1).remove(arco);
				return;
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		//Complejidad O(1)
		return  vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		//Complejidad O(N)
		if (contieneVertice(verticeId1) && vertices.get(verticeId1).isEmpty()) {
			for (Arco<T> arco : vertices.get(verticeId1)) {
				if (arco.getVerticeDestino() == verticeId2) {
					//si pasa eso existe arco
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (vertices.get(verticeId1) == null) {
			return null;
		}
		if (!vertices.get(verticeId1).isEmpty()) {
			//Complejidad O(N)
			for (Arco<T> arco : vertices.get(verticeId1)) {
				if (arco.getVerticeDestino() == verticeId2) {
					//si pasa eso retorno el arco
					return arco;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		//Complejidad O(N)
		int cantidad = 0;
		for (ArrayList<Arco<T>> arcosDelVertice: this.vertices.values()) {
			cantidad += arcosDelVertice.size();
		}
		return cantidad;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		//Complejidad O(N)
		ArrayList<Arco<T>> verticeConArcos = vertices.get(verticeId);
		ArrayList<Integer> adyacentes = new ArrayList<>();
		if(!verticeConArcos.isEmpty()) {
			for (Arco<T> arco : verticeConArcos) {
				adyacentes.add(arco.getVerticeDestino());
			}
			return adyacentes.iterator();
		}
		return null;
	}


	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		//Complejidad O(N)
		ArrayList<Arco<T>> arcosObtenidos = new ArrayList<>();
		for (ArrayList<Arco<T>> arcosDelVertice : this.vertices.values()) {
			arcosObtenidos.addAll(arcosDelVertice);
		}
		return arcosObtenidos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		//Complejidad O(N)
		if (contieneVertice(verticeId)) {
			ArrayList<Arco<T>> arcos = vertices.get(verticeId);
			return arcos.iterator();
		}
		return null;
	}
}
