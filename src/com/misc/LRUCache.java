package com.misc;

import java.util.HashMap;
import java.util.Map;

// lru cache implementation
public class LRUCache<K, V> {

    Queue queue;
    Map<K, Node> map;

    LRUCache(int capacity) {
        queue = new Queue(null, null, 0, capacity);
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCache<String, String> o = new LRUCache(2);
        o.accessPage("1", "one");
        o.show();
        o.accessPage("2", "two");
        o.show();
        Object[] remove = o.remove("1");
        System.out.println("*******");
        System.out.println(remove[0] + ", " + remove[1]);
        System.out.println("*******");
        o.show();
        o.accessPage("3", "three");
        o.show();
        o.accessPage("4", "four");
        o.show();
    }

    void accessPage(K page, V value) {
        if (map.get(page) != null) {
            Node node = map.get(page);
            moveToHead(node);
        } else {
            Node node = addToList(page, value);
            map.put(page, node);
        }
    }

    private Node addToList(K page, V value) {
        if (queue.head == null) {
            queue.head = new Node(page, value);
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

        Node newHead = new Node(page, value);
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

    Object[] remove(K key){
        if (map.get(key) == null){
            return null;
        }else {
            Node node = map.get(key);

            if (queue.head == node){
                queue.head = queue.head.next;
                queue.head.prev = null;
            }else if (queue.tail == node){
                queue.tail = queue.tail.prev;
                queue.tail.next = null;
            }else {
                Node next = node.next;
                Node prev = node.prev;

                prev.next = next;
                if (next!=null){
                    next.prev = prev;
                }
            }
            queue.size--;
            map.remove(node);
            return new Object[]{node.data, node.value};
        }
    }

    void show() {
        Node head = queue.head;
        while (head != null) {
            System.out.print(head.data + "->" + head.value + ", ");
            head = head.next;
        }
        System.out.println("\n========");
    }

    class Node<K, V> {
        K data;
        V value;
        Node next, prev;

        public Node(K data, V value) {
            this.data = data;
            this.value = value;
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
