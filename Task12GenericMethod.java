public class Task12GenericMethod {

    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Integer[] numbers = {10, 20, 30};
        String[] names = {"Rahul", "Ananya", "Kiran"};
        Character[] characters = {'A', 'B', 'C'};

        System.out.println("Integer Array:");
        printArray(numbers);

        System.out.println("String Array:");
        printArray(names);

        System.out.println("Character Array:");
        printArray(characters);
    }
}