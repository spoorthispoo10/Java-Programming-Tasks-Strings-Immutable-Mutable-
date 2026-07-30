public class Task3StringBuilder {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Hello");

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
    }
}