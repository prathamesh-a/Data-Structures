package me.prathamesh.LinkedList;

import java.util.NoSuchElementException;

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
            size++;
        }
    }

    /**
     * Removes and returns the head(first element) of this list.
     *
     * @return first element of this list
     * @throws NoSuchElementException if the list empty
     */
    public T deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException("list is empty");
        Node<T> temp = head;
        if (head == tail) tail = null;
        else head.next.prev = null;
        head = head.next;
        temp.next = null;
        size--;
        return temp.data;
    }

    /**
     * Removes and returns the tail(last element) of this list.
     *
     * @return last element of this list
     * @throws NoSuchElementException if the list is empty
     */
    public T deleteLast() {
        if (isEmpty()) throw new NoSuchElementException("list is empty");
        Node<T> temp = tail;
        if (head == tail) head = null;
        else tail.prev.next = null;
        tail = tail.prev;
        temp.prev = null;
        size--;
        return temp.data;
    }

    /**
     * Removes and return the first element(head) of this list.
     *
     * @return head of this list
     * @throws NoSuchElementException if the list is empty
     */
    public T delete() {
        return deleteFirst();
    }

    /**
     * Removes and return element at specified index.
     *
     * @param index index of the element to be removed
     * @return element at specified index in this list
     *
     * @throws IndexOutOfBoundsException if specified index is not valid
     * @throws NoSuchElementException if the list is empty
     */
    public T delete(int index) {
        if (index < 0 || index > size()-1) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        if (index == 0) return deleteFirst();
        else if (index == size()-1) return deleteLast();
        else {
            Node<T> current = head;
            int position = 0;
            while (index > position) {
                current = current.next;
                position++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return current.data;
        }
    }

    /**
     * Removes the first occurrence of specified object from this list, if present.
     * If the element is not present this list remains unchanged.
     *
     * @param o element required to be removed from this list
     * @return true if the element is present in this list
     * @throws NullPointerException if the specified object is null
     */
    public boolean delete(Object o) {
        if (o == null) throw new NullPointerException("object cannot be null");
        if (o.equals(head.data)) {
            deleteFirst();
            return true;
        }
        else {
            Node<T> current = head;
            while (current != null) {
                if (o.equals(current.data)) {
                    if (current.next == null) deleteLast();
                    else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    /**
     * Removes the first occurrence of specified object from this list, if present.
     * If the element is not present this list remains unchanged.
     *
     * @param o element required to be removed from this list
     * @return true if the element is present in this list
     * @throws NullPointerException if the specified object is null
     */
    public boolean deleteFirstOccurrence(Object o) {
        return delete(o);
    }

    /**
     * Returns the first element(head) of this list.
     *
     * @return head(first element) of this list
     * @throws NoSuchElementException if the list is empty
     */
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException("list is empty");
        return head.data;
    }

    /**
     * Returns the last element of this list.
     *
     * @return last element of this list
     * @throws NoSuchElementException if the list is empty
     */
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException("list is empty");
        return tail.data;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        if (index < 0 || index > size-1) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        Node<T> current = head;
        int count = 0;
        while (count < index) {
            current = current.next;
            count++;
        }
        return current.data;
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
