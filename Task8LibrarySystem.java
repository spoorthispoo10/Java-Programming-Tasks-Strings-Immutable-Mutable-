import java.util.HashSet;

public class Task8LibrarySystem {
    public static void main(String[] args) {

        HashSet<String> books = new HashSet<>();

        books.add("Java Programming");
        books.add("Python Programming");
        books.add("Database Management");
        books.add("Java Programming");

        System.out.println("Unique Books:");

        for (String book : books) {
            System.out.println(book);
        }

        System.out.println("Total Unique Books: " + books.size());
    }
}
