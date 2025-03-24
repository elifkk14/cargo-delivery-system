//----------------------------------------------------- 
// Title: Stack Class
// Author: Elif Konak
// ID: 15235113326
// Section: 02
// Assignment: 01
// Description: This class implements a generic stack using a linked list.
//-----------------------------------------------------

public class Stack<T> {
    private Node<T> top;  // Top node of the stack
    private int size;  // Size of the stack

    private static class Node<T> {
        T data;  // Data stored in the node
        Node<T> next;  // Reference to the next node

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        //--------------------------------------------------------
        // Summary: Constructor to initialize an empty stack.
        // Precondition: None.
        // Postcondition: A Stack object is created with top set to null and size set to 0.
        //--------------------------------------------------------
        this.top = null;
        this.size = 0;
    }

    public void push(T data) {
        //--------------------------------------------------------
        // Summary: Adds a new element to the top of the stack.
        // Precondition: data is a non-null object.
        // Postcondition: The new element is added to the top of the stack.
        //--------------------------------------------------------
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        //--------------------------------------------------------
        // Summary: Removes the top element from the stack.
        // Precondition: The stack is not empty.
        // Postcondition: The top element is removed and its data is returned. Returns null if the stack is empty.
        //--------------------------------------------------------
        if (top == null) {
            return null; 
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public boolean isEmpty() {
        //--------------------------------------------------------
        // Summary: Checks if the stack is empty.
        // Precondition: None.
        // Postcondition: Returns true if the stack is empty, false otherwise.
        //--------------------------------------------------------
        return size == 0;
    }

    public int size() {
        //--------------------------------------------------------
        // Summary: Gets the size of the stack.
        // Precondition: None.
        // Postcondition: Returns the number of elements in the stack.
        //--------------------------------------------------------
        return size;
    }

    public CargoPackage[] toArray(CargoPackage[] cargoArray) {
        //--------------------------------------------------------
        // Summary: Converts the stack to an array.
        // Precondition: cargoArray is a non-null array with a length of at least the size of the stack.
        // Postcondition: The elements of the stack are copied to the array.
        //--------------------------------------------------------
        Node<T> current = top;
        for (int i = 0; i < size; i++) {
            cargoArray[i] = (CargoPackage) current.data;
            current = current.next;
        }
        return cargoArray;
    }
}
