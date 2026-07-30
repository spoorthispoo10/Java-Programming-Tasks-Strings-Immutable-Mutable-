class SharedData {

    private int value;
    private boolean available = false;

    public synchronized void produce(int value) {

        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        this.value = value;
        available = true;

        System.out.println("Produced: " + value);

        notify();
    }

    public synchronized void consume() {

        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Consumed: " + value);

        available = false;

        notify();
    }
}

class Producer implements Runnable {

    private SharedData data;

    public Producer(SharedData data) {
        this.data = data;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            data.produce(i);
        }
    }
}

class Consumer implements Runnable {

    private SharedData data;

    public Consumer(SharedData data) {
        this.data = data;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            data.consume();
        }
    }
}

public class Task23ProducerConsumer {

    public static void main(String[] args) {

        SharedData data = new SharedData();

        Thread producer = new Thread(new Producer(data));
        Thread consumer = new Thread(new Consumer(data));

        producer.start();
        consumer.start();
    }
}