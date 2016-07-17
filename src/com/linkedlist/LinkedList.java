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

    void insertAtTail(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            Node newnode = new Node(data);
            temp.next = newnode;
        }
    }

    void insertAtLocation(int data, int position) {
        if (head == null) {
            head = new Node(data);
        } else {
            if (position == 0)
                insertAtHead(data);
            else {
                Node temp = head;
                int locationBeforeIndex = 0;
                while (locationBeforeIndex != position - 1) {
                    temp = temp.next;
                    locationBeforeIndex++;
                }

                Node newnode = new Node(data);
                newnode.next = temp.next;
                temp.next = newnode;
            }
        }
    }

    void deleteFromHead() {
        if (head == null)
            return;
        head = head.next;
    }

    void deleteFromTail() {
        if (head == null)
            return;
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null)
                temp = temp.next;

            temp.next = null;
        }
    }

    void reverse() {
        Node a = head;
        Node b, c = null;
        while (a != null) {
            b = a;
            a = a.next;
            b.next = c;
            c = b;
        }
        head = c;
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
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.show();
        list1.insertAtHead(5);
        list1.show();
        list1.insertAtTail(10);
        list1.show();
        list1.insertAtLocation(7, 0);
        list1.show();
        list1.insertAtLocation(8, 2);
        list1.show();

        list1.reverse();
        list1.show();

        list1.deleteFromHead();
        list1.show();
        list1.deleteFromTail();
        list1.show();
    }
}
