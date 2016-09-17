package com.dp;

import java.util.Arrays;

/**
 * Created by nakulkumar on 17/9/16.
 */
public class LIS {
    static int lis(int a[]){
        int temp[] = new int[a.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=1;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j]<a[i] && temp[i]<temp[j]+1)
                    temp[i]=temp[j]+1;
            }
        }

        int max = temp[0];
        for (int i = 1; i < temp.length; i++) {
            if (max<temp[i])
                max=temp[i];
        }

        System.out.println(Arrays.toString(temp));

        int x = max;
        for (int i= temp.length-1;i>=0;i--){
            if(temp[i]==x){
                System.out.print(a[i]+" ");
                x--;
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        System.out.println("Length of lis is " + lis( arr) + "\n" );
    }
}
