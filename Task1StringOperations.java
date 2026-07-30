import java.util.Scanner;

public class Task1StringOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("Length: " + str.length());
        System.out.println("First Character: " + str.charAt(0));
        System.out.println("Last Character: " + str.charAt(str.length() - 1));
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());

        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        System.out.println("Reverse: " + reverse);

        if (str.equalsIgnoreCase(reverse)) {
            System.out.println("Palindrome: Yes");
        } else {
            System.out.println("Palindrome: No");
        }

        sc.close();
    }
}
