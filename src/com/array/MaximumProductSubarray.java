package com.array;

// https://www.geeksforgeeks.org/maximum-product-subarray/
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int arr[] = {1, -2, -3, 0, 7, -8, -2};
        System.out.println(maxSubarrayProduct(arr));
        System.out.println(maxSubarrayProduct1(arr));
        System.out.println(maxSubarrayProduct2(arr));

        int b[] = {-1, -1};
        System.out.println(maxSubarrayProduct(b));
        System.out.println(maxSubarrayProduct1(b));
        System.out.println(maxSubarrayProduct2(b));

        int c[] = {-2, -1};
        System.out.println(maxSubarrayProduct(c));
        System.out.println(maxSubarrayProduct1(c));
        System.out.println(maxSubarrayProduct2(c));

        int d[] = {-2};
        System.out.println(maxSubarrayProduct(d));
        System.out.println(maxSubarrayProduct1(d));
        System.out.println(maxSubarrayProduct2(d));

        int e[] = {0};
        System.out.println(maxSubarrayProduct(e));
        System.out.println(maxSubarrayProduct1(e));
        System.out.println(maxSubarrayProduct2(e));

        int f[] = {4, -10, 6, 8, 9};
        System.out.println(maxSubarrayProduct(f));
        System.out.println(maxSubarrayProduct1(f));
        System.out.println(maxSubarrayProduct2(f));

    }

    static int maxSubarrayProduct1(int a[]) {
        int pos[] = new int[a.length];
        int neg[] = new int[a.length];
        int maxprod = a[0];
        pos[0] = a[0];
        neg[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            pos[i] = Math.max(Math.max(pos[i - 1] * a[i], neg[i - 1] * a[i]), a[i]);    //maximum of the three
            neg[i] = Math.min(Math.min(pos[i - 1] * a[i], neg[i - 1] * a[i]), a[i]);    //minimum of the three
            maxprod = Math.max(maxprod, pos[i]);
        }
        return maxprod;
    }

    static int maxSubarrayProduct2(int a[]) {
        int maxVal = a[0];
        int minVal = a[0];
        int maxProd = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            maxVal = Math.max(a[i], maxVal * a[i]);
            minVal = Math.min(a[i], minVal * a[i]);

            maxProd = Math.max(maxProd, maxVal);
        }
        return maxProd;
    }

    private static int maxSubarrayProduct(int[] a) {
        int maxprod = a[0];
        int curr = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] != 0) {
                curr = curr * a[i];
            } else {
                curr = 1;
            }
            if (curr > maxprod) {
                maxprod = curr;
            }
        }
        return maxprod;
    }
}
