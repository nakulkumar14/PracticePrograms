package com.array;

//https://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/
public class LargestSubarraySumOfAlteastSizeK {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, -10, 2};
        int k = 4;
        System.out.println(maxSumWithK(arr, k));

        int b[] = {-4, -2, 1, -3};
        k = 2;
        System.out.println(maxSumWithK(b, k));

        int c[] = {1, 1, 1, 1, 1, 1};
        k = 2;
        System.out.println(maxSumWithK(c, k));
    }

    private static int maxSumWithK(int[] arr, int k) {
        int maxsum[] = new int[arr.length];
        int currsum = 0;
        for (int i = 0; i < arr.length; i++) {
            currsum = Math.max(currsum + arr[i], arr[i]);
            maxsum[i] = currsum;
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            result += arr[i];
        }
        int max = result;
        for (int i = k; i < arr.length; i++) {
            result += arr[i] - arr[i - k];
            max = Math.max(max, result);
            max = Math.max(max, result + maxsum[i - k]);
        }

        return max;
    }
}
