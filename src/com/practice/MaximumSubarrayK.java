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
            while (!q.isEmpty() && a[q.peekLast()] <= a[i])
                q.removeLast();
            q.addLast(i);
        }
//        System.out.println("first : "+ q);

        for (;i<a.length;i++){
            System.out.print(a[q.peek()]+" ");

            // remove elements that are not required in this window
            while(!q.isEmpty() && q.peek() <= i-k)
                q.removeFirst();
//            System.out.println("remove 1 : "+q);
            // remove all unwanted elements from last
            while(!q.isEmpty() && a[q.peekLast()] <= a[i])
                q.removeLast();

//            System.out.println("remove 2 : "+q);
            q.addLast(i);

//            System.out.println("added: "+q);
        }
        System.out.println(a[q.peek()]);
    }

    static void dpSolution(int a[], int k){
        int l[] = new int[a.length];
        int r[] = new int[a.length];

        for (int i = 1; i < a.length; i++) {
            if (i%k==1)
                l[i] = a[i];
            else
                l[i] = Math.max(l[i-1], a[i]);
        }

        for (int i = a.length-1; i >0 ; i--) {
            if (i%k==0 || i == a.length-1)
                r[i] = a[i];
            else
                r[i] = Math.max(r[i+1], a[i]);
        }

        int windows = a.length-k+1;

        for (int i = 1; i<=windows ; i++) {
            int max = Math.max(r[i], l[i+k-1]);
            System.out.println(i + " " + max);
        }
    }

    public static void main(String[] args) {
//        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int arr[] = {8,5,10,7,9,4,15,12,90,13};
        int k = 3;
        printKMax(arr,k);
//        dpSolution(arr, k);
    }
}
