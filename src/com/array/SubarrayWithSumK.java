package com.array;

//https://www.geeksforgeeks.org/find-subarray-with-given-sum/
public class SubarrayWithSumK {
    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        subArraySum(arr, sum);

        int b[] = {1, 4, 0, 0, 3, 10, 5};
        sum = 7;
        subArraySum(b, sum);

        int c[] = {1, 4};
        sum = 0;
        subArraySum(c, sum);

        int d[] = {15, 2, 4, 8, 9, 5, 10, 23};
        sum = 23;
        subArraySum(d, sum);
    }

    private static void subArraySum(int[] arr, int sum) {
        int curr_sum = arr[0];
        int start = 0;
        for (int i = 1; i < arr.length; i++) {

            while (curr_sum > sum && start < i - 1) {
                curr_sum -= arr[start];
                start++;
            }

            if (curr_sum == sum) {
                System.out.println("Found at : " + start + " to " + (i - 1));
                break;
            }

            curr_sum += arr[i];
        }

        if (sum == 0) {
            System.out.println("Not found");
        }
    }
}
