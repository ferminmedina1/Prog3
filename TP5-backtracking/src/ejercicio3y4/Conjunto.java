package ejercicio3y4;
import java.util.LinkedList;
public class Conjunto {

    private LinkedList<Integer> n;


    public Conjunto() {
        this.n = new LinkedList<>();
    }

    public void addNumeros(int num) {
        if (!this.n.contains(num)) {
            n.add(num);
        }
    }

    //Ejercicio 3
    public LinkedList<Integer> sumSubconjuntos(int m) {
        LinkedList<Integer> resultado = new LinkedList<>();
        LinkedList<Integer> current = new LinkedList<>();
        sumSubconjuntos(m, this.n , resultado, current, 0);
        return resultado;
    }

    private void sumSubconjuntos(int m, LinkedList<Integer> n , LinkedList<Integer> resultado,
                                 LinkedList<Integer> current, int index) {
        if (sum(current) == m) {
            resultado.addAll(current);
        }
        //                PODA!!
        else if (sum(current) < m && index < n.size()) {


            current.add(n.get(index));
            sumSubconjuntos(m, n, resultado, current, index + 1);


            current.removeLast();
            sumSubconjuntos(m, n, resultado, current, index + 1);
        }
    }

    private int sum (LinkedList<Integer> list) {
        int sum = 0;
        for (int num: list ) {
            sum += num;
        }
        return sum;
    }


    //Ejercicio 4
    public boolean equalsSumPartition() {
        return equalsSumPartition(new LinkedList<>(), new LinkedList<>(), 0);
    }

    private boolean equalsSumPartition(LinkedList<Integer> list1, LinkedList<Integer> list2, int index) {
        if (index == n.size()) {
            return sum(list1) == sum(list2) && !list1.isEmpty() && !list2.isEmpty();
        }

        // Agregar el elemento actual a list1
        list1.add(n.get(index));
        if (equalsSumPartition(list1, list2, index + 1)) {
            return true;
        }
        list1.removeLast();

        // Agregar el elemento actual a list2
        list2.add(n.get(index));
        if (equalsSumPartition(list1, list2, index + 1)) {
            return true;
        }
        list2.removeLast();

        return false;
    }

}
