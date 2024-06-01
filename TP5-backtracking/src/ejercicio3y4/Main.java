package ejercicio3y4;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 3

        Conjunto conjuntos = new Conjunto();

        conjuntos.addNumeros(6);
        conjuntos.addNumeros(4);
        conjuntos.addNumeros(5);
        conjuntos.addNumeros(3);
        conjuntos.addNumeros(2);


        System.out.println(conjuntos.sumSubconjuntos(10));

        //Ejercicio 4

        System.out.println(conjuntos.equalsSumPartition());
    }
}
