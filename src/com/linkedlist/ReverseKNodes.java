package com.linkedlist;

/**
 * Created by nakulkumar on 31/7/16.
 */
public class ReverseKNodes {

    Node head;

    void push(int data) {
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
    }

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void revK(int k) {
        head = reverseK(head, k);
        show();
    }

    Node reverseK(Node head, int k) {
        Node curr = head;
        Node b, c = null;

        int count = 0;
        while (curr != null && count < k) {
            b = curr;
            curr = curr.next;
            b.next = c;
            c = b;
            count++;
        }

        if (curr != null)
            head.next = reverseK(curr, k);
        return c;
    }

    public static void main(String[] args) {
        ReverseKNodes r = new ReverseKNodes();
        r.push(1);
        r.push(2);
        r.push(3);
        r.push(4);
        r.push(5);
        r.push(6);
        r.push(7);
        r.push(8);
        r.show();
        r.revK(2);
    }
}
