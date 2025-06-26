import java.util.ArrayList;

public class GenericsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Java Generics Demo ===\n");
        
        
        System.out.println("1. Generic Class:");
        Box<String> stringBox = new Box<>("Hello World");
        Box<Integer> intBox = new Box<>(42);
        
        System.out.println("String Box: " + stringBox.getValue());
        System.out.println("Integer Box: " + intBox.getValue());
        System.out.println();
        
        
        System.out.println("2. Generic ArrayList:");
        ArrayList<String> names = new ArrayList<>();
        names.add("Enki");
        names.add("Ali");
        names.add("Moied");
        
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(25);
        numbers.add(32);
        numbers.add(54);
        
        System.out.println("Names: " + names);
        System.out.println("Numbers: " + numbers);
        System.out.println();
        
        
        System.out.println("3. Generic Static Methods:");
        
        
        printArray(new String[]{"bmw", "mazda", "benz"});
        printArray(new Integer[]{25, 32, 54, 67, 89});
        printArray(new Double[]{1.1, 2.2, 3.3});
        
        
        String middle1 = getMiddleElement(new String[]{"bmw", "mazda", "benz"});
        Integer middle2 = getMiddleElement(new Integer[]{25, 32, 54});
        
        System.out.println("Middle of strings: " + middle1);
        System.out.println("Middle of integers: " + middle2);
        System.out.println();
        
        
        System.out.println("4. Multiple Type Parameters:");
        Pair<String, Integer> pair1 = createPair("Age", 32);
        Pair<String, String> pair2 = createPair("Name", "Enki");
        
        System.out.println("Pair 1: " + pair1.getFirst() + " = " + pair1.getSecond());
        System.out.println("Pair 2: " + pair2.getFirst() + " = " + pair2.getSecond());
    }
    
        public static <T> void printArray(T[] array) {
        System.out.print("Array: ");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
        public static <T> T getMiddleElement(T[] array) {
        return array[array.length / 2];
    }
    
        public static <T, U> Pair<T, U> createPair(T first, U second) {
        return new Pair<>(first, second);
    }
}

class Box<T> {
    private T value;
    
    public Box(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
}


class Pair<T, U> {
    private T first;
    private U second;
    
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst() {
        return first;
    }
    
    public U getSecond() {
        return second;
    }
}