package com.misc;

import java.util.HashMap;
import java.util.Map;

// lru cache implementation
public class LRUCache {

    Queue queue;
    Map<Integer, Node> map;

    LRUCache(int capacity) {
        queue = new Queue(null, null, 0, capacity);
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCache o = new LRUCache(2);
        o.accessPage(1);
        o.show();
        o.accessPage(2);
        o.show();
        o.accessPage(4);
        o.show();
        o.accessPage(3);
        o.show();
    }

    void accessPage(int page) {
        if (map.get(page) != null) {
            Node node = map.get(page);
            moveToHead(node);
        } else {
            Node node = addToList(page);
            map.put(page, node);
        }
    }

    private Node addToList(int page) {
        if (queue.head == null) {
            queue.head = new Node(page);
            queue.tail = queue.head;
            queue.size = 1;
            return queue.head;
        } else if (queue.size < queue.capacity) {
            queue.size++;
        } else {
            Node temp = queue.tail;
            queue.tail = queue.tail.prev;
            queue.tail.next = null;
            map.remove(temp.data);
        }

        Node newHead = new Node(page);
        newHead.next = queue.head;
        queue.head.prev = newHead;
        queue.head = newHead;
        return queue.head;
    }

    private void moveToHead(Node node) {
        if (queue.head == node) {
            return;
        } else if (queue.tail == node) {
            queue.tail = queue.tail.prev;
            queue.tail.next = null;
        }

        Node prev = node.prev;
        Node next = node.next;
        prev.next = null;
        if (next != null) {
            next.prev = next;
        }
        node.next = queue.head;
        node.prev = null;
        queue.head.prev = node;
        queue.head = node;

    }

    void show() {
        Node head = queue.head;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("\n========");
    }

    class Node {
        int data;
        Node next, prev;

        public Node(int data) {
            this.data = data;
        }
    }

    class Queue {
        Node head, tail;
        int size, capacity;

        public Queue(Node head, Node tail, int size, int capacity) {
            this.head = head;
            this.tail = tail;
            this.size = size;
            this.capacity = capacity;
        }
    }
}
