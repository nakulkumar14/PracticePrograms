package com.array;

// https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k/
public class LongestSubarraySumOfAtmostK {
    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 0, 1, 1, 0};
        int k = 4;
        System.out.println(atMostSum(arr, k));

        int b[] = {1, 2, -1, -2, 5, 1, 1, 0};
        k = 4;
        System.out.println(atMostSum(b, k));
    }

    private static int atMostSum(int[] arr, int k) {
        int end = 0, beg = 0;
        int len = 0;
        int sum = 0;
        int s = 0, e = 0;
        while (end < arr.length) {
            if (sum <= k) {
                sum += arr[end++];
            } else {
                sum -= arr[beg++];
            }

            if (len <= end - beg) {
                len = end - beg;
                s = beg;
                e = end;
            }
        }

        for (int i = s; i < e; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return len;
    }
}
