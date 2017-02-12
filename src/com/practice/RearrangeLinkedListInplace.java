package com.practice;

/**
 * Created by nakul on 12-Feb-17.
 * Examples:
 Input:  1 -> 2 -> 3 -> 4
 Output: 1 -> 4 -> 2 -> 3

 Input:  1 -> 2 -> 3 -> 4 -> 5
 Output: 1 -> 5 -> 2 -> 4 -> 3
 */
public class RearrangeLinkedListInplace {

    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next=null;
        }
    }

    static Node head;

    static void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static void rearrange(){
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // find the middle element and reverse afterwards and join to original list
        slow.next = reverse(slow.next);

        Node temp = head;
        Node tail = slow.next;

        // from the mid of the list start merging with start of the list
        while(tail.next!=null){
            slow.next = tail.next;
            tail.next = temp.next;
            temp.next = tail;
            temp = tail.next;
            tail = slow.next;
        }
    }

    static Node reverse(Node r){
        Node a = r;
        Node b,c=null;
        while(a!=null){
            b=a;
            a=a.next;
            b.next=c;
            c=b;
        }

        return c;
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next  = new Node(5);
        head.next.next.next.next.next  = new Node(6);
        display();
        rearrange();
        display();
    }
}
