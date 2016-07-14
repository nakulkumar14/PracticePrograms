package com.practice;

/**
 * Created by nakulkumar on 14/7/16.
 * <p/>
 * Element is leader if greater than all elements on right.
 * [16,17,4,3,5,2]
 * <p/>
 * [17,5,2]
 * <p/>
 * Note : Last element of array is always a leader.
 */
public class LeadersofArray {

    public static void main(String[] args) {
        int a[] = {16, 17, 4, 3, 5, 2};
        System.out.print("Array : ");
        Util.showArray(a);

        System.out.println("Output :");
        int max = a[a.length - 1];
        System.out.print(max + " ");
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > max) {
                System.out.print(a[i] + " ");
                max = a[i];
            }
        }
        System.out.println();
    }
}
