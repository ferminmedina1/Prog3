package ejercicio5;

import java.util.LinkedList;

public class Processor {
    private LinkedList<Task> tasks;

    public Processor() {
        this.tasks = new LinkedList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    public int getTotalTime() {
        int totalTime = 0;
        for (Task task: this.tasks) {
            totalTime += task.getTimeExecution();
        }
        return totalTime;
    }

    @Override
    public String toString() {
        return "Processor";
    }
}
