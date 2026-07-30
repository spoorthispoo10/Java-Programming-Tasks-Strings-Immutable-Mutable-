public class Task16MultipleCatch {
    public static void main(String[] args) {

        try {
            int a = 10 / 0;

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred.");

        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred.");

        } catch (NullPointerException e) {
            System.out.println("NullPointerException occurred.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred.");
        }
    }
}