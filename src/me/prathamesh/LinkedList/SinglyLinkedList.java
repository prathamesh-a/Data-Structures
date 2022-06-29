package me.prathamesh.LinkedList;

public class SinglyLinkedList {

    private Node head;

    private static class Node {
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder str = new StringBuilder();
        while (current != null) {
            str.append(current.data).append(" --> ");
            current = current.next;
        }
        str.append("null");
        return str.toString();
    }
}
