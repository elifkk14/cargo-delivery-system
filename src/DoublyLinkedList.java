//----------------------------------------------------- 
// Title: DoublyLinkedList Class
// Author: Elif Konak
// ID: 15235113326
// Section: 02
// Assignment: 01
// Description: This class implements a doubly linked list.
//-----------------------------------------------------

public class DoublyLinkedList<T> {
    private Node<T> head;  // Head node of the list
    private Node<T> tail;  // Tail node of the list
    private int size;  // Size of the list

    public static class Node<T> {
        T data;  // Data stored in the node
        Node<T> next;  // Reference to the next node
        Node<T> prev;  // Reference to the previous node

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList() {
        //--------------------------------------------------------
        // Summary: Constructor to initialize an empty doubly linked list.
        // Precondition: None.
        // Postcondition: A DoublyLinkedList object is created with head and tail set to null and size set to 0.
        //--------------------------------------------------------
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T data) {
        //--------------------------------------------------------
        // Summary: Adds a new node with the specified data at the beginning of the list.
        // Precondition: data is a non-null object.
        // Postcondition: The new node is added at the beginning of the list.
        //--------------------------------------------------------
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        //--------------------------------------------------------
        // Summary: Adds a new node with the specified data at the end of the list.
        // Precondition: data is a non-null object.
        // Postcondition: The new node is added at the end of the list.
        //--------------------------------------------------------
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        //--------------------------------------------------------
        // Summary: Removes the first node from the list.
        // Precondition: The list is not empty.
        // Postcondition: The first node is removed and its data is returned. Returns null if the list is empty.
        //--------------------------------------------------------
        if (head == null) return null;
        T data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    public T removeLast() {
        //--------------------------------------------------------
        // Summary: Removes the last node from the list.
        // Precondition: The list is not empty.
        // Postcondition: The last node is removed and its data is returned. Returns null if the list is empty.
        //--------------------------------------------------------
        if (tail == null) return null;
        T data = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty() {
        //--------------------------------------------------------
        // Summary: Checks if the list is empty.
        // Precondition: None.
        // Postcondition: Returns true if the list is empty, false otherwise.
        //--------------------------------------------------------
        return size == 0;
    }

    public int size() {
        //--------------------------------------------------------
        // Summary: Gets the size of the list.
        // Precondition: None.
        // Postcondition: Returns the number of elements in the list.
        //--------------------------------------------------------
        return size;
    }

    public T getFirst() {
        //--------------------------------------------------------
        // Summary: Gets the data of the first node in the list.
        // Precondition: The list is not empty.
        // Postcondition: Returns the data of the first node. Returns null if the list is empty.
        //--------------------------------------------------------
        if (head == null) return null;
        return head.data;
    }

    public T getLast() {
        //--------------------------------------------------------
        // Summary: Gets the data of the last node in the list.
        // Precondition: The list is not empty.
        // Postcondition: Returns the data of the last node. Returns null if the list is empty.
        //--------------------------------------------------------
        if (tail == null) return null;
        return tail.data;
    }

    public T removeAtIndex(int index) {
        //--------------------------------------------------------
        // Summary: Removes the node at the specified index.
        // Precondition: index is a valid position within the list.
        // Postcondition: The node at the specified index is removed and its data is returned. Returns null if the index is invalid.
        //--------------------------------------------------------
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            T data = current.data;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return data;
        }
    }

    public T[] toArray(T[] array) {
        //--------------------------------------------------------
        // Summary: Converts the list to an array.
        // Precondition: array is a non-null array with a length of at least the size of the list.
        // Postcondition: The elements of the list are copied to the array.
        //--------------------------------------------------------
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    public DoublyLinkedList.Node<T> getHead() {
        //--------------------------------------------------------
        // Summary: Gets the head node of the list.
        // Precondition: None.
        // Postcondition: Returns the head node.
        //--------------------------------------------------------
        return head;
    }
}
