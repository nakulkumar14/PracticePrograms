package com.linkedlist;

/**
 * Created by nakulkumar on 8/7/16.
 */
//Two numbers are represented by 2 linkedlists.
// Find the resultant linkedlist represented as sum of these given linkedlists.

public class SumOfLinkedList {

    LinkedList addLists(LinkedList list1, LinkedList list2){
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        LinkedList list3 = new LinkedList();
        Node head1 = list1.getHead();
        Node head2 = list2.getHead();

        int carry = 0;

        while(head1 !=null && head2!=null){
//            System.out.println(head1.data + ", " + head2.data + ", " + carry);
            int data = head1.data + head2.data + carry;
            carry = data/10;
            data = data%10;

//            System.out.println(data + ", " + carry);
            list3.insertAtTail(data);

            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1==null){
            while(head2!=null){
                int data = head2.data + carry;
                carry = data/10;
                data = data%10;

                list3.insertAtTail(data);
            }
        }

        if (head2==null){
            while(head1!=null){
                int data = head1.data + carry;
                carry = data/10;
                data = data%10;

                list3.insertAtTail(data);
            }
        }

        if (carry>0){
            list3.insertAtTail(carry);
        }

        return list3;

    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertAtTail(9);
        list1.insertAtTail(8);
        list1.insertAtTail(7);
        list1.show();

        LinkedList list2 = new LinkedList();
        list2.insertAtTail(6);
        list2.insertAtTail(2);
        list2.insertAtTail(5);
        list2.show();

        SumOfLinkedList o = new SumOfLinkedList();
        LinkedList list = o.addLists(list1, list2);
        list.show();

    }
}
