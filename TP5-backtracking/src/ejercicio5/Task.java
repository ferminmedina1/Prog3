package ejercicio5;
public class Task {
    private int timeExecution;
    public Task(int timeExecution) {
        this.timeExecution = timeExecution;
    }
    public int getTimeExecution() {
        return timeExecution;
    }

    @Override
    public String toString() {
        return "timeExecution=" + timeExecution;
    }
}
