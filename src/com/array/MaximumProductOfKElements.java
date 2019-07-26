package com.array;

// https://www.geeksforgeeks.org/largest-product-subarray-size-k/
public class MaximumProductOfKElements {
    public static void main(String[] args) {
        int arr1[] = {1, 5, 9, 8, 2, 4, 1, 8, 1, 2};
        int k = 6;
        System.out.println(findMaxProduct(arr1, k));

        k = 4;
        System.out.println(findMaxProduct(arr1, k));

        int arr2[] = {2, 5, 8, 1, 1, 3};
        k = 3;
        System.out.println(findMaxProduct(arr2, k));
    }

    private static int findMaxProduct(int[] arr, int k) {
        int maxProd = 1;
        for (int i = 0; i < k; i++) {
            maxProd *= arr[i];
        }
        int prod = maxProd;

        for (int i = k; i < arr.length; i++) {
            int currProd = (prod / arr[i - k]) * arr[i];
            maxProd = Math.max(currProd, maxProd);
            prod = currProd;
        }

        return maxProd;
    }
}
