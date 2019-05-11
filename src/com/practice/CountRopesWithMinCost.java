package com.practice;

import java.util.Arrays;

// https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
public class CountRopesWithMinCost {

    public static void main(String[] args) {
        int len[] = {4, 3, 2, 6};
        minCost(len);
    }

    private static void minCost(int[] arr) {
        Arrays.sort(arr);

        int i = 0, j = 0, sum = 0, n = arr.length;
        sum = arr[0] + arr[1];
        i = 1;

        while (i < n) {
            sum += (arr[i] + arr[j]);
            arr[j] = (arr[i] + arr[j]);
            i++;
        }

        System.out.println(arr[j]);
        System.out.println(Arrays.toString(arr));


    }
}
