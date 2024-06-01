package ejercicio5;

import java.util.HashMap;
import java.util.LinkedList;

public class AsignadorTareas {
    private LinkedList<Processor> processors;
    private HashMap<Processor, LinkedList<Task>> bestSolution;
    private int bestTime;


    public AsignadorTareas(int numProcesadores) {
        this.processors = new LinkedList<>();
        this.bestSolution = new HashMap<>();
        this.bestTime = 0;

        for (int i = 0; i < numProcesadores; i++) {
            this.processors.add(new Processor());
        }
    }

    public void addTasksToProcessors(LinkedList<Task> tasks) {
        addTasksToProcessors(tasks, 0, new HashMap<>());
        System.out.println(bestSolution);
        System.out.println(bestTime);
    }

    // Estado de mi solucion -> current (HashMap<Processor, <LinkedList<Task>>
    private void addTasksToProcessors(LinkedList<Task> tasks, int indexTask, HashMap<Processor, LinkedList<Task>> current) {
        if (indexTask >= tasks.size()) {
            int maxTime = getMaxTime(current);
            if (maxTime < bestTime || bestTime == 0) {
                this.bestTime = maxTime;
                this.bestSolution = deepCopy(current);
            }
            return;
        }

        Task task = tasks.get(indexTask);

        for (Processor processor : this.processors) {
            //si current no visito el procesador actual
            if (!current.containsKey(processor)) {
                current.put(processor, new LinkedList<>());
            }

            current.get(processor).add(task);
            processor.addTask(task);

            addTasksToProcessors(tasks, indexTask + 1, current);

            processor.removeTask(task);
            current.get(processor).removeLast();
        }
    }

    private int getMaxTime(HashMap<Processor, LinkedList<Task>> current) {
        int maxTime = 0;
        for (Processor processor : this.processors) {
            if (current.containsKey(processor)) {
                maxTime = Math.max(maxTime, processor.getTotalTime());
            }
        }
        return maxTime;
    }

    private HashMap<Processor, LinkedList<Task>> deepCopy(HashMap<Processor, LinkedList<Task>> original) {
        HashMap<Processor, LinkedList<Task>> copy = new HashMap<>();
        for (Processor processor : original.keySet()) {
            copy.put(processor, new LinkedList<>(original.get(processor)));
        }
        return copy;
    }

}
