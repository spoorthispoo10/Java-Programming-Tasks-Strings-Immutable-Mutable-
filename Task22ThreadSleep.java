public class Task22ThreadSleep {

    public static void main(String[] args) {

        for (int i = 10; i >= 1; i--) {

            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }

        System.out.println("Time's up!");
    }
}