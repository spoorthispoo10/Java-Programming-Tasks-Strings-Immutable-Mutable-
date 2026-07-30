public class Task4StringBuffer {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Hello");

        System.out.println("Original: " + sb);

        sb.append(" Java");
        System.out.println("After Append: " + sb);

        sb.insert(6, "World ");
        System.out.println("After Insert: " + sb);

        sb.delete(6, 12);
        System.out.println("After Delete: " + sb);

        sb.replace(0, 5, "Hi");
        System.out.println("After Replace: " + sb);

        sb.reverse();
        System.out.println("After Reverse: " + sb);

        System.out.println("\nStringBuffer is thread-safe.");
        System.out.println("StringBuilder is faster but not thread-safe.");
    }
}