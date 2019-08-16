package com.linkedlist;

public class PalindromeLinkedList {

    static boolean isPalindrome(LinkedList l1, LinkedList l2) {
        if (l1 == null && l2 == null)
            return true;
        if (l1 == null || l2 == null)
            return false;

        Node h1 = l1.getHead();
        Node h2 = l2.getHead();

        while (h1 != null && h2 != null) {
            if (h1.data != h2.data)
                return false;
            h1 = h1.next;
            h2 = h2.next;
        }

        if (h1 != null || h2 != null)
            return false;

        return true;

    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertAtTail(3);
        list1.insertAtTail(3);
        list1.insertAtTail(3);
//        list1.insertAtTail(1);
        list1.show();

        LinkedList list2 = new LinkedList(list1);
        list2.show();
        list2.reverse();
        list2.show();
        list1.show();

        System.out.println(isPalindrome(list1, list2));

    }
}
