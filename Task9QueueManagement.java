import java.util.LinkedList;
import java.util.Queue;

public class Task9QueueManagement {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        queue.add("Rahul");
        queue.add("Ananya");
        queue.add("Kiran");
        queue.add("Spoorthi");

        System.out.println("Queue: " + queue);

        System.out.println("Next Customer: " + queue.peek());

        System.out.println("Serving: " + queue.poll());
        System.out.println("Serving: " + queue.poll());

        System.out.println("Remaining Queue: " + queue);
    }
}