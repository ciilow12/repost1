import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class checkbox {
    public static void main(String[] args) {
        // Create a stack of integers
        ArryStack<Integer>   Stack1= new ArryStack<>();

        // Push some elements
        Stack1.push(100);
        Stack1.push(200);
        Stack1.push(300);

        // Display the stack
        Stack1.display();

        // Peek at the top element
        System.out.println("Top element (peek): " + Stack1.peek());

        // Pop an element
        System.out.println("Popped element: " + Stack1.pop());

        // Display again after popping
        Stack1.display();

        // Push another element
        Stack1.push(40);
        Stack1.push(50);

        // Display final stack
        Stack1.display();

        // Show size
        System.out.println("Current stack size: " + Stack1.size());

        // Check if empty
        System.out.println("Is the stack empty? " + Stack1.isEmpty());
    }
}

class ArryStack<T> {
    private static final int CONST = 4;
    private int topup;
    private T[] StackVariable;

    // No-arg constructor
    ArryStack() {
        this(CONST);
    }

    ArryStack(int Valueinizilize) {
        topup = 0;
        StackVariable= (T[]) (new Object[Valueinizilize]);
    }

    // size
    public int size() {
        return topup;
    }

    // push method
    public void push(T element_value) {
        if (size() == StackVariable.length)
            Expand();
        StackVariable[topup] = element_value;
        topup++;
    }

    // pop method
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        else {
            T Output =StackVariable[--topup];
            StackVariable[topup] = null;
            return Output;
        }
    }

    // peek method
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return StackVariable[topup - 1];
    }

    // isEmpty method
    public boolean isEmpty() {
        return topup == 0;
    }

    // expand method
    public void Expand() {
        StackVariable = Arrays.copyOf(StackVariable, StackVariable.length * 2);
    }

    // display method
    public void display() {
        if (isEmpty())
            throw new EmptyStackException();
        else {
            System.out.println("The element of the Stack is :");
            for (int x = 0; x < topup; x++)
                System.out.print(StackVariable[x] + " ");
            System.out.println();
        }
  }
}
