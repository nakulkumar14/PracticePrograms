package com.practice;

import java.util.Scanner;

/**
 * Created by nakulkumar on 16/7/16.
 * We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:
 * <p/>
 * a b c
 * d
 * e f g
 * There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values.
 * <p/>
 * Task
 * Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.
 * <p/>
 * Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.
 * <p/>
 * Input Format
 * <p/>
 * There are  lines of input, where each line contains  space-separated integers describing 2D Array ; every value in  will be in the inclusive range of  to .
 * <p/>
 * Constraints
 * <p/>
 * Output Format
 * <p/>
 * Print the largest (maximum) hourglass sum found in .
 * <p/>
 * Sample Input
 * <p/>
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * Sample Output
 * <p/>
 * 19
 * Explanation
 * <p/>
 * contains the following hourglasses:
 * <p/>
 * 1 1 1   1 1 0   1 0 0   0 0 0
 * 1       0       0       0
 * 1 1 1   1 1 0   1 0 0   0 0 0
 * <p/>
 * 0 1 0   1 0 0   0 0 0   0 0 0
 * 1       1       0       0
 * 0 0 2   0 2 4   2 4 4   4 4 0
 * <p/>
 * 1 1 1   1 1 0   1 0 0   0 0 0
 * 0       2       4       4
 * 0 0 0   0 0 2   0 2 0   2 0 0
 * <p/>
 * 0 0 2   0 2 4   2 4 4   4 4 0
 * 0       0       2       0
 * 0 0 1   0 1 2   1 2 4   2 4 0
 * The hourglass with the maximum sum () is:
 * <p/>
 * 2 4 4
 * 2
 * 1 2 4
 */
public class HourglassSum {

    static void display(int a[][], int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int arr_i = 0; arr_i < 6; arr_i++) {
            for (int arr_j = 0; arr_j < 6; arr_j++) {
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        display(arr, 6, 6);

        // initilaized max to large negative value since array elements
        //  are betweem -9 to 9. Hourglass sum can be -9*7 = -63.
        int k, j;
        int sum = 0, maxsum = -99999;
        for (int i = 0; i <= 6 - 3; i++) {
            k = 1;
            j = 0;
            while (j <= 3) {
                sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                sum += arr[i + 1][k];
                sum += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (sum > maxsum) {
                    maxsum = sum;
                }

                j++;
                k++;
                sum = 0;
            }
        }

        System.out.println(maxsum);
    }
}
