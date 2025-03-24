//----------------------------------------------------- 
// Title: Queue Class
// Author: Elif Konak
// ID: 15235113326
// Section: 02
// Assignment: 01
// Description: This class implements a generic queue using a linked list.
//-----------------------------------------------------

public class Queue<T> {
    private Node<T> front; // Reference to the front node
    private Node<T> rear; // Reference to the rear node
    private int size; // Number of elements in the queue

    private static class Node<T> {
        T data;  // Data stored in the node
        Node<T> next;  // Reference to the next node

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        //--------------------------------------------------------
        // Summary: Constructor to initialize an empty queue.
        // Precondition: None.
        // Postcondition: A Queue object is created with front and rear set to null and size set to 0.
        //--------------------------------------------------------
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        //--------------------------------------------------------
        // Summary: Adds a new element to the rear of the queue.
        // Precondition: data is a non-null object.
        // Postcondition: The new element is added to the rear of the queue.
        //--------------------------------------------------------
        Node<T> newNode = new Node<>(data);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;  
        }
        size++;
    }

    public T dequeue() {
        //--------------------------------------------------------
        // Summary: Removes the front element from the queue.
        // Precondition: The queue is not empty.
        // Postcondition: The front element is removed and its data is returned. Returns null if the queue is empty.
        //--------------------------------------------------------
        if (front == null) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty() {
        //--------------------------------------------------------
        // Summary: Checks if the queue is empty.
        // Precondition: None.
        // Postcondition: Returns true if the queue is empty, false otherwise.
        //--------------------------------------------------------
        return size == 0;
    }

    public int size() {
        //--------------------------------------------------------
        // Summary: Gets the size of the queue.
        // Precondition: None.
        // Postcondition: Returns the number of elements in the queue.
        //--------------------------------------------------------
        return size;
    }
}
