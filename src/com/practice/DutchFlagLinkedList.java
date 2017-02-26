package com.practice;

/**
 * Created by nakul on 01-Jan-17.
 * <p>
 * Sort linked list containing only 0,1 and 2.
 */
public class DutchFlagLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    static void sort(Node head) {

        //Dummy nodes used to point to respective head of lists
        Node Zero = new Node(0);
        Node One = new Node(0);
        Node Two = new Node(0);

        Node zero = Zero, one = One, two = Two, curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
                curr = curr.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
                curr = curr.next;
            } else {
                two.next = curr;
                two = two.next;
                curr = curr.next;
            }
        }

        // point to head of respective lists
        zero.next = (One.next != null) ? (One.next) : (Two.next);
        one.next = Two.next;
        two.next = null;
        head = Zero.next;

        System.out.println("sorted : ");
        display(head);
    }

    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 0);
        head = insert(head, 1);
        head = insert(head, 0);
        head = insert(head, 2);
        head = insert(head, 1);
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 1);
        head = insert(head, 2);

        display(head);
        sort(head);
    }
}
