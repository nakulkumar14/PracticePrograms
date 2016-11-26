package com.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nakul on 20-Nov-16.
 */
// LRU Cache implementation
public class LRUCache {
    class Node{
        int page;
        Node prev,next;

        public Node(int page) {
            this.page = page;
            this.prev = this.next = null;
        }
    }

    static class Dequeue{
        int pno;
        int filled;
        Node front,rear;
        Dequeue(int pno){
            this.pno = pno;
            this.filled = 0;
            this.front = this.rear = null;
        }
    }

    Map<Integer,Node> map = new HashMap<Integer,Node>();

    static void display(Dequeue d){
        Dequeue temp = d;
        int pageno=0;
        while (pageno!=temp.pno){
            System.out.print(temp.front.page+" ");
            pageno++;
            temp.front = temp.front.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Dequeue d = new Dequeue(5);
        display(d);
    }
}
