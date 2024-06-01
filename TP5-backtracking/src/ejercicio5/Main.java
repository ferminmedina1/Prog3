package ejercicio5;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 5
        // Crear las tareas con los tiempos de ejecución dados
        Task task1 = new Task(2);
        Task task2 = new Task(3);
        Task task3 = new Task(7);
        Task task4 = new Task(1);
        Task task5 = new Task(4);


        // Crear una lista de tareas y agregar las tareas a la lista
        LinkedList<Task> tasks = new LinkedList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);


        // Crear el AsignadorTareas con 3 procesadores
        AsignadorTareas asignadorTareas = new AsignadorTareas(3);

        // Asignar las tareas a los procesadores
        asignadorTareas.addTasksToProcessors(tasks);

    }

}
