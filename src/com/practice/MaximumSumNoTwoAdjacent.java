package com.practice;

/**
 * Created by nakul on 20/8/17.
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
 */
public class MaximumSumNoTwoAdjacent {

    static void maximumSumNoTwoElementAdjacent(int a[]){
        int incl = a[0], excl = 0, excl_new=0;
        for (int i = 1; i < a.length; i++) {
            excl_new = Math.max(incl,excl);
            incl = excl + a[i];
            excl = excl_new;
        }

        System.out.println(Math.max(incl,excl));
    }

    public static void main(String[] args) {
        int arr[] = {5, 5, 10, 100, 10, 5};
        maximumSumNoTwoElementAdjacent(arr);

        int a[] = {1, 2, 3};
        maximumSumNoTwoElementAdjacent(a);

        int b[] = {5,  5, 10, 40, 50, 35};
        maximumSumNoTwoElementAdjacent(b);
    }
}
