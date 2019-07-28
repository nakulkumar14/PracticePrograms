package com.array;

// https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
public class MaximumSubarraySumofSizeK {
    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSum(arr, k));

        int b[] = {100, 200, 300, 400};
        k = 2;
        System.out.println(maxSum(b, k));

        int c[] = {2, 3};
        k = 3;
        System.out.println(maxSum(c, k));

        int d[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        k = 4;
        System.out.println(maxSum(d, k));
    }

    private static int maxSum(int[] arr, int k) {

        if (k > arr.length) {
            return -1;
        }

        int sum = 0;
        int maxsum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        maxsum = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            maxsum = Math.max(sum, maxsum);
        }

        return maxsum;
    }
}
