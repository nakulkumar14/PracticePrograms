package com.linkedlist;

/**
 * Created by nakul on 11-Sep-16.
 */
public class ReverseKMNodes {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    void insert(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /**
     * The method takes two nos. and reverses first k numbers and then skips m numbers
     * and repeats the process.
     */
    void reverseKMNodes(int k, int m) {
        head = reverse(head,k,m);
    }

    Node reverse(Node temp,int k,int m){
        if (temp==null){
            return temp;
        }

        int count = 0;
        Node a=temp,b,c=null;

        while (a!=null && count<k){
            b=a;
            a=a.next;
            b.next=c;
            c=b;
            count++;
        }

        temp.next = a;
        Node prev=null;
        for (int i = 0; i < m && a!=null; i++) {
            prev=a;
            a=a.next;
        }
        if (a!=null){
            prev.next = reverse(a,k,m);
        }

        return c;
    }

    public static void main(String[] args) {
        ReverseKMNodes ob = new ReverseKMNodes();
        ob.insert(1);
        ob.insert(2);
        ob.insert(3);
        ob.insert(4);
        ob.insert(5);
        ob.insert(6);
        ob.insert(7);
        ob.insert(8);
        ob.insert(9);
        ob.show();
        ob.reverseKMNodes(3,2);
        System.out.println();
        ob.show();
    }
}
