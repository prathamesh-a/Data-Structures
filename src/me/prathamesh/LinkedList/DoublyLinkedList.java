package me.prathamesh.LinkedList;

public class DoublyLinkedList<T> {
    private int size;

    /**
     * Pointer to the head(first noode) of this list.
     */
    private Node<T> head;

    /**
     * Pointer to the tail(last node) of this list.
     */
    private Node<T> tail;

    private static class Node<E> {
        private final E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data) {
            this.data = data;
        }
    }

    /**
     * Constructs an empty doubly linked list.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Returns the size of this doubly linked list.
     * @return size of this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list is empty otherwise returns false.
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Insert the specified element at the beginning of this doubly list.
     *
     * @param val value of the node to be inserted
     * @throws NullPointerException if the value is null
     */
    public void insertFirst(T val) {
        if (val == null) throw new NullPointerException("value cannot be null");
        Node<T> newNode = new Node<>(val);
        if (isEmpty()) tail = newNode;
        else head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Insert the specified element at the end of this doubly linked list.
     *
     * @param val value of the node to be inserted
     * @throws NullPointerException if the value is null
     */
    public void insertLast(T val) {
        if (val == null) throw new NullPointerException("value cannot be null");
        Node<T> newNode = new Node<>(val);
        if (isEmpty()) head = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    /**
     * Insert the specified element at the beginning of this list.
     *
     * @param val value of the node to be inserted
     * @throws NullPointerException if the value is null
     */
    public void insert(T val) {
        insertLast(val);
    }

    /**
     * Insert a new node at a specified index in this doubly linked list.
     *
     * @param val value of the node to be inserted
     * @param position index for inserting new node (starts from 0)
     *
     * @throws NullPointerException if the specified value is null
     * @throws IndexOutOfBoundsException if the specified index is not valid
     */
    public void insert(T val, int position) {
        if (val == null) throw new NullPointerException("value cannot be null");
        if (position > size || position < 0) throw new IndexOutOfBoundsException("Size = " + size + ", Index = " + position);
        if (position == 0) insertFirst(val);
        else if (position == size) insertLast(val);
        else {
            Node<T> newNode = new Node<>(val);
            Node<T> current = head;
            int index = 0;
            while (index < position) {
                current = current.next;
                index++;
            }
            Node<T> prev = current.prev;
            newNode.prev = prev;
            prev.next = newNode;
            newNode.next = current;
            current.prev = newNode;
        }
    }

    /**
     * Return the string representation of this doubly linked list.
     * The string representation consists of a list of the elements enclosed in square brackets ("[]").
     *
     * @return string representation of the doubly linked list
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node<T> temp = head;
        while (temp != null) {
            str.append(temp.data).append(",");
            temp = temp.next;
        }
        if (head != null) str.deleteCharAt(str.length()-1);
        str.append("]");
        return str.toString();
    }

    /**
     * Returns the string representing the doubly linked list visual with help of arrows. This gives simplified representation.
     *
     * @return simplified string representation of this list
     */
    public String toVisualRepresentation() {
        StringBuilder str = new StringBuilder("[");
        if (head != null) str.append("NULL <--> ");
        Node<T> temp = head;
        while (temp != null) {
            str.append(temp.data).append(" <--> ");
            temp = temp.next;
        }
        if (head != null) str.append("NULL");
        str.append("]");
        return str.toString();
    }
}
