package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nakulkumar on 30/7/16.
 */
public class SegregateVowelsList {

    class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    void insert(char data) {
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
        System.out.println();
    }

    void segregateVowels() {
        if (head == null)
            return;

        Node temp = head;
        Node end = null;
        while (temp.next != null) {
            temp = temp.next;
        }
        end = temp;
        Node newEnd = end;
        System.out.println("first consonant set as head");
        show();

        List<Character> chars = new ArrayList<>();
        chars.add('a');
        chars.add('e');
        chars.add('i');
        chars.add('o');
        chars.add('u');

        boolean flag = true;
        temp = head;
        while (chars.contains((Character) temp.data)) {
            newEnd.next = temp;
            newEnd = newEnd.next;

            temp = temp.next;
            newEnd.next = null;
        }

        head = temp;
        Node prev = null;

        while (temp != end) {

            if (chars.contains((Character) temp.data)) {
                newEnd.next = temp;
                newEnd = newEnd.next;
                temp = temp.next;
                newEnd.next = null;
                prev.next = temp;
                show();
            } else {
                prev = temp;
                temp = temp.next;
            }
        }

        if (chars.contains((Character) end.data)) {
            newEnd.next = end;
            prev.next = end.next;
            newEnd = newEnd.next;
            newEnd.next = null;
        }

    }

    public static void main(String[] args) {
        SegregateVowelsList s = new SegregateVowelsList();
        s.insert('i');
        s.insert('r');
        s.insert('t');
        s.insert('a');
        s.insert('y');
        s.insert('a');
        s.insert('g');
        s.show();

        s.segregateVowels();
        s.show();
    }
}
