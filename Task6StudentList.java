import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task6StudentList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> students = new ArrayList<>();

        students.add("Rahul");
        students.add("Ananya");
        students.add("Spoorthi");
        students.add("Kiran");

        System.out.println("All Students: " + students);

        System.out.print("Enter name to search: ");
        String search = sc.nextLine();

        if (students.contains(search)) {
            System.out.println("Student found.");
        } else {
            System.out.println("Student not found.");
        }

        System.out.print("Enter student to remove: ");
        String remove = sc.nextLine();

        students.remove(remove);

        Collections.sort(students);

        System.out.println("After Removal and Sorting: " + students);

        sc.close();
    }
}