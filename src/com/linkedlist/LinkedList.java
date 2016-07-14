package com.linkedlist;

/**
 * Created by nakulkumar on 14/7/16.
 */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    private Node head;

    void insertAtHead(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
        }
    }

    boolean isEmpty() {
        return head == null ? true : false;
    }

    void show() {
        if (isEmpty()) {
            System.out.println("Empty list.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(head.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.show();
        list1.insertAtHead(5);
        list1.show();
    }
}
