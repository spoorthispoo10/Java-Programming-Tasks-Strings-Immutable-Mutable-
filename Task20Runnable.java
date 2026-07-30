class StudentThread implements Runnable {

    public void run() {

        String[] students = {
                "Rahul",
                "Ananya",
                "Kiran",
                "Spoorthi"
        };

        for (String student : students) {
            System.out.println(student);
        }
    }
}

public class Task20Runnable {
    public static void main(String[] args) {

        StudentThread task = new StudentThread();

        Thread thread = new Thread(task);

        thread.start();
    }
}