package com.practice;

/**
 * Created by nakul on 20-Nov-16.
 */

// Find second smallest and second largest in single traversal
public class SecondSmallestAndLargest {

    static void find(int a[]){
        int max,min,smax,smin;
        max = smax = Integer.MIN_VALUE;
        min = smin = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i]<max && a[i]>smax)
                smax=a[i];
            else if(a[i]>max){
                smax=max;
                max=a[i];
            }

            if (a[i]>min && a[i]<smin)
                smin=a[i];
            else if (a[i]<min){
                smin=min;
                min=a[i];
            }
        }

        System.out.println("Max : "+max+", second max : "+smax);
        System.out.println("Min : "+min+", second min : "+smin);
    }

    public static void main(String[] args) {
        int a[]={5,7,9,3,-1,18,6};
        find(a);
    }
}
