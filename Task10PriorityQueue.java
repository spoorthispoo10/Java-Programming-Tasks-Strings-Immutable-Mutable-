import java.util.PriorityQueue;

public class Task10PriorityQueue {
    public static void main(String[] args) {

        PriorityQueue<Integer> tasks = new PriorityQueue<>();

        tasks.add(3);
        tasks.add(1);
        tasks.add(5);
        tasks.add(2);
        tasks.add(4);

        System.out.println("Task Execution Order:");

        while (!tasks.isEmpty()) {
            System.out.println("Executing Task Priority: " + tasks.poll());
        }
    }
}