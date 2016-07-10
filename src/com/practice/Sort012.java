package com.practice;

/**
 * Created by nakulkumar on 10/7/16.
 */

/**
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[].
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * Example
 * Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
 * Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */
public class Sort012 {

    static void sort(int a[]) {
        int low = 0, mid = 0, high = a.length - 1;
        int temp;
        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    temp = a[low];
                    a[low] = a[mid];
                    a[mid] = temp;
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = a[high];
                    a[high] = a[mid];
                    a[mid] = temp;
                    high--;
                    break;
            }
        }
    }

    static void show(int a[]) {
        for (int e : a) {
            System.out.print(e + "");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        show(a);
        sort(a);
        show(a);
    }
}
