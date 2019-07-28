package com.array;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-subarray-with-given-sum/
public class SubarrayWithSumK {
    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        subArraySum(arr, sum);
        subArraySum1(arr, sum);

        int b[] = {1, 4, 0, 0, 3, 10, 5};
        sum = 7;
        subArraySum(b, sum);
        subArraySum1(b, sum);

        int c[] = {1, 4};
        sum = 0;
        subArraySum(c, sum);
        subArraySum1(c, sum);

        int d[] = {15, 2, 4, 8, 9, 5, 10, 23};
        sum = 23;
        subArraySum(d, sum);
        subArraySum1(d, sum);

        int e[] = {10, 2, -2, -20, 10};
        sum = -10;
        subArraySum(e, sum);
        subArraySum1(e, sum);
    }

    // handles negative elements as well
    private static void subArraySum1(int[] arr, int sum) {
        int curr = 0;
        int s = 0;
        int e = 0;
        int f = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            if (curr - sum == 0) {
                s = 0;
                e = i;
                f = 1;
                break;
            }
            if (map.containsKey(curr - sum)) {
                s = map.get(curr - sum) + 1;
                e = i;
                f = 1;
                break;
            }
            map.put(curr, i);
        }

        if (f == 1)
            System.out.println("Found at : " + s + " to " + e);
        else
            System.out.println("Not found");

    }

    private static void subArraySum(int[] arr, int sum) {
        int curr_sum = arr[0];
        int start = 0;
        int f = 0;
        for (int i = 1; i < arr.length; i++) {

            while (curr_sum > sum && start < i - 1) {
                curr_sum -= arr[start];
                start++;
            }

            if (curr_sum == sum) {
                System.out.println("Found at : " + start + " to " + (i - 1));
                f = 1;
                break;
            }

            curr_sum += arr[i];
        }

        if (f == 0) {
            System.out.println("Not found");
        }
    }
}
