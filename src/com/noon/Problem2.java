package com.noon;

import java.util.Arrays;

// arr of integers, +ve and -ve. find sum of two numbers closest to zero.
public class Problem2 {

    public static void main(String[] args) {
        int arr[] = {-30, -4, -7, -10, -20};
        closestToZero(arr);
        closestZero(arr);
    }

    private static void closestToZero(int[] arr) {
        int sum = Integer.MAX_VALUE;
        int tempSum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                tempSum = arr[i] + arr[j];
                if (Math.abs(tempSum) < Math.abs(sum)) {
                    sum = tempSum;
                }
            }
        }

        System.out.println("Result=" + sum);
    }

    private static void closestZero(int arr[]) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        int sum = Integer.MAX_VALUE;
        while (i < j) {
            if (Math.abs(arr[i] + arr[j]) < Math.abs(sum)) {
                sum = arr[i] + arr[j];
            }

            if ((arr[i] + arr[j]) > 0) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Result=" + sum);
    }
}
