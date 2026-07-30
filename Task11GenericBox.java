class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class Task11GenericBox {
    public static void main(String[] args) {

        Box<Integer> intBox = new Box<>();
        intBox.setValue(100);

        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello Java");

        Box<Double> doubleBox = new Box<>();
        doubleBox.setValue(99.99);

        System.out.println("Integer: " + intBox.getValue());
        System.out.println("String: " + stringBox.getValue());
        System.out.println("Double: " + doubleBox.getValue());
    }
}