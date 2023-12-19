import java.util.Stack;

public class LifoExample {
    public static void main(String[] args) {
        // Create a Stack
        Stack<Integer> lifoStack = new Stack<>();

        // Push elements onto the stack (Last-In)
        lifoStack.push(10);
        lifoStack.push(20);
        lifoStack.push(30);

        // Display the stack contents
        System.out.println("Stack elements: " + lifoStack);

        // Pop elements from the stack (First-Out)
        int poppedElement = lifoStack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after popping: " + lifoStack);

        // Peek at the top element without removing it
        int topElement = lifoStack.peek();
        System.out.println("Top element (without removing): " + topElement);
        System.out.println("Stack after peek: " + lifoStack);

        lifoStack.push(70);
        System.out.println("Stack after new push" + lifoStack);
    }
}
