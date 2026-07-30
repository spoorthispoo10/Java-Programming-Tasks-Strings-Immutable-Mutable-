import java.util.Scanner;

public class Task5WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        int words = 0;
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int specialCharacters = 0;

        String trimmed = sentence.trim();

        if (!trimmed.isEmpty()) {
            words = trimmed.split("\\s+").length;
        }

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (Character.isLetter(ch)) {
                if ("AEIOUaeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (!Character.isWhitespace(ch)) {
                specialCharacters++;
            }
        }

        System.out.println("Total Words: " + words);
        System.out.println("Total Vowels: " + vowels);
        System.out.println("Total Consonants: " + consonants);
        System.out.println("Total Digits: " + digits);
        System.out.println("Total Special Characters: " + specialCharacters);

        sc.close();
    }
}