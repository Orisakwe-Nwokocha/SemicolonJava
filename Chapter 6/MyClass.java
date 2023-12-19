public class MyClass {
    // Static variable
    public static int count = 0;

    // Constructor
    public MyClass() {
        count++; // Increment count each time a new object is created
    }

    public static void main(String[] args) {
        // Accessing the static variable without creating an object
        System.out.println("Initial count: " + MyClass.count);

        // Creating objects of MyClass
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();

        // Accessing the static variable through the class name
        System.out.println("Count after creating objects: " + MyClass.count); // Output will be 2
        System.out.println("Count in obj1: " + obj1.count); // Also prints 2
        System.out.println("Count in obj2: " + obj2.count); // Also prints 2
    }
}
