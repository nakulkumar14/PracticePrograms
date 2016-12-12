package com.practice;

import java.util.ArrayDeque;

/**
 * Created by nakul on 12-Dec-16.
 *
 * Maximum of all subarrays of size k (Added a O(n) method)
 Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

 Examples:

 Input :
 arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 k = 3
 Output :
 3 3 4 5 5 5 6

 Input :
 arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 k = 4
 Output :
 10 10 10 15 15 90 90
 */
public class MaximumSubarrayK {

    static void printKMax(int a[],int k){
        ArrayDeque<Integer> q = new ArrayDeque<>();

        int i;
        for (i = 0; i < k; i++) {
            if (!q.isEmpty() && a[q.getLast()] <= a[i])
                q.removeLast();
            q.addLast(i);
        }
//        System.out.println("first : "+ q);

        for (;i<a.length;i++){
            System.out.print(a[q.getFirst()]+" ");

            // remove elements that are not required in this window
            while(!q.isEmpty() && q.getFirst() <= i-k)
                q.removeFirst();
//            System.out.println("remove 1 : "+q);
            // remove all unwanted elements from last
            while(!q.isEmpty() && a[q.getLast()] <= a[i])
                q.removeLast();

//            System.out.println("remove 2 : "+q);
            q.addLast(i);

//            System.out.println("added: "+q);
        }
        System.out.println(a[q.getFirst()]);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        printKMax(arr,k);
    }
}
