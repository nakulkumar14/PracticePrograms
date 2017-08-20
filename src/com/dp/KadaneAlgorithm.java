package com.dp;

/**
 * Created by nakul on 20/8/17.
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which
 * has the largest sum.
 */
public class KadaneAlgorithm {

    static void maximumcontiguoussum(int a[]) {
        int max_so_far = a[0], max_ending_here = a[0];
        int start = 0, s = 0, end = 0;
        for (int i = 1; i < a.length; i++) {
            max_ending_here+=a[i];
            if (max_ending_here<0){
                max_ending_here = 0;
                s=i+1;
            }else if (max_so_far < max_ending_here){
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
        }

        System.out.println("Max sum : "+max_so_far);
        for (int i = start; i <=end ; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        maximumcontiguoussum(a);
    }

}
