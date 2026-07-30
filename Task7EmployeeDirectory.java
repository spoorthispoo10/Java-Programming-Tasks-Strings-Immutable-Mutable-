import java.util.HashMap;

public class Task7EmployeeDirectory {
    public static void main(String[] args) {

        HashMap<Integer, String> employees = new HashMap<>();

        // Add
        employees.put(101, "Rahul");
        employees.put(102, "Ananya");
        employees.put(103, "Kiran");

        System.out.println("All Employees: " + employees);

        // Search
        System.out.println("Employee 101: " + employees.get(101));

        // Update
        employees.put(102, "Ananya Sharma");

        // Delete
        employees.remove(103);

        System.out.println("After Update and Delete: " + employees);
    }
}