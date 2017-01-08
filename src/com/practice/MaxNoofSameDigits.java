package com.practice;

/**
 * Created by nakul on 08-Jan-17.
 * Given a positive integer, find maximum integer possible by doing at-most K swap operations on its digits.
 */
public class MaxNoofSameDigits {

    static void largestNo(int a[],int k){
        int max;
        for (int i = 0; i < k; i++) {
            max=i;
            for (int j = i+1; j < a.length; j++) {
                if (a[max] < a[j])
                    max=j;
            }
            if (max!=i){
                int temp = a[max];
                a[max]=a[i];
                a[i]=temp;
            }else{
                break;
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[]={2,5,4};
        largestNo(a,2);
    }
}
