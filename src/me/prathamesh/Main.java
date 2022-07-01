package me.prathamesh;

import me.prathamesh.LinkedList.SinglyLinkedList;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList<String > linkedList = new SinglyLinkedList<>();
        linkedList.insertFirst("two");
        linkedList.insertFirst("one");
        System.out.println(linkedList);
    }
}
