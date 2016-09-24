package com.dp;

/**
 * Created by nakulkumar on 18/9/16.
 */
public class CoinChange {

    static int coinChange(int a[], int n) {
        int table[][]=new int[n+1][a.length];

        for (int i = 0; i < a.length; i++) {
            table[0][i]=1;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < a.length; j++) {
                int x = (i-a[j])>=0?table[i-a[j]][j]:0;
                int y = j>=1?table[i][j-1]:0;
                table[i][j]=x+y;
            }
        }

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }


        return table[n][a.length-1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int n = 4;
        System.out.println(coinChange(arr, n));
    }
}
