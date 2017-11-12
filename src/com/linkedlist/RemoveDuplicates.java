package com.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    void removeDuplicatesUsingHash(Node head){
        if (head==null)
            return;
        Set<Integer> set = new HashSet<>();
        Node curr = head;
        Node prev = null;
        while (curr!=null){
            if (set.contains(curr.data)){
                prev.next = curr.next;
            }else{
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtTail(10);
        list.insertAtTail(12);
        list.insertAtTail(11);
        list.insertAtTail(11);
        list.insertAtTail(12);
        list.insertAtTail(11);
        list.insertAtTail(10);

        list.show();

        RemoveDuplicates r = new RemoveDuplicates();
        r.removeDuplicatesUsingHash(list.getHead());
        list.show();
    }
}
