package com.practice;

/**
 * Created by nakulkumar on 23/8/16.
 */
public class ReverseKArray {
    static void rev(int a[], int s, int e) {
        int temp;
        while (s < e) {
            temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;

        for (int i = 0; i < a.length; i+=k) {
            if (i + k-1 < a.length)
                rev(a, i, i + k-1);
            else
                rev(a, i, i + k-1);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

}
