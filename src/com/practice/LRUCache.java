package com.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nakul on 20-Nov-16.
 */
// LRU Cache implementation
public class LRUCache {

    Queue queue;            // contain pages in which they are accessed
    Map<Integer,Node> map;  // contain map of pages with their addresses in queue.

    public LRUCache(int capacity) {
        queue = new Queue(null,null,0,capacity);
        map = new HashMap<>();
    }

    class Node{
        int page;
        Node prev,next;

        public Node(int page) {
            this.page = page;
            this.prev = this.next = null;
        }
    }

    class Queue{
        Node head,tail;
        int size,capacity;

        public Queue(Node head, Node tail, int size, int capacity) {
            this.head = head;
            this.tail = tail;
            this.size = size;
            this.capacity = capacity;
        }
    }

    // Add node to the head of the list.
    Node addToList(int data){
        // if queue is empty make head and tail same.
        if (queue.head == null){
            queue.head = new Node(data);
            queue.tail = queue.head;
            queue.size = 1;

            return queue.head;
        }
        else if (queue.size < queue.capacity)   // increase the size of queue.
            queue.size++;
        else{
            // if queue is full, remove the tail.
            queue.tail = queue.tail.prev;
            queue.tail.next = null;
        }

        // create the new node and add to head of queue and set the references properly.
        Node newHead = new Node(data);
        newHead.next = queue.head;
        queue.head.prev = newHead;
        queue.head = newHead;

        return queue.head;
    }

    void moveToHead(Node page){

        // if node to be moved is at head then return.
        if (queue.head == page)
            return;

        // if node to be moved to head is at tail remove the tail.
        if (queue.tail == page){
            queue.tail = queue.tail.prev;
            queue.tail.next = null;
        }

        // adjust the next and prev pointers of node to be moved.
        Node prev = page.prev;
        Node next = page.next;
        prev.next = next;
        if (next!=null)
            next.prev = prev;

        // make node as head.
        page.next = queue.head;
        page.prev = null;
        queue.head.prev = page;

        queue.head = page;
    }

    // print contents of queue.
    void show(){
        Node temp = queue.head;
        while (temp!=queue.tail){
            System.out.print(temp.page + " ");
            temp = temp.next;
        }
        System.out.println(queue.tail.page);
    }

    void accessPage(int page){

        // check if page to be accessed is in map
        // if so move it to head of queue.
        if (map.get(page)!=null){
            Node node = map.get(page);
            moveToHead(node);
        }else{

            // if queue is full, remove tail
            if (queue.size == queue.capacity)
                map.remove(queue.tail.page);

            // add node to queue and put in map.
            Node node = addToList(page);
            map.put(page, node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.accessPage(1);
        lruCache.accessPage(2);
        lruCache.accessPage(3);
        lruCache.accessPage(1);
        lruCache.accessPage(4);
        lruCache.accessPage(5);

        lruCache.show();

    }
}
