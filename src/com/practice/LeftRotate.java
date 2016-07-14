package com.practice;

/**
 * Created by nakulkumar on 14/7/16.
 */
// Left rotate array by d elements.
public class LeftRotate {
    static void reverse(int a[], int s, int n) {
        int i = s, j = n - 1;
        int temp;
        while (i <= j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    static void show(int a[]) {
        for (int x : a)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        show(a);
        reverse(a, 0, 3);
        reverse(a, 3, a.length);
        reverse(a, 0, a.length);
        show(a);
    }
}
