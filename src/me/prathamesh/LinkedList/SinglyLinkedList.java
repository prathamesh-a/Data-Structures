package me.prathamesh.LinkedList;

public class SinglyLinkedList<T> {

    private Node<T> head;

    private static class Node<E> {
        private final E data;
        private Node<E> next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Inserts the new node at the beginning of the linked list.
     * The new node is created as per the given value.
     *
     * @param val integer value for the node to be inserted
     * @throws NullPointerException if the specified value is null
     */
    public void insertFirst(T val) {
        if (val == null) throw new NullPointerException();
        Node<T> newNode = new Node<>(val);
        newNode.next = head;
        head = newNode;
    }

    public int size() {
        if (head == null) return 0;
        int count = 0;
        Node<T> current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public String toString() {
        Node<T> current = head;
        StringBuilder str = new StringBuilder("[");
        while (current != null) {
            str.append(current.data).append(",");
            current = current.next;
        }
        str.deleteCharAt(str.length()-1);
        str.append("]");
        return str.toString();
    }
}
