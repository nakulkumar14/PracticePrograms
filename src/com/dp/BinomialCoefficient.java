package com.dp;

/**
 * Created by nakul on 25-Sep-16.
 */
public class BinomialCoefficient {

    static int binomialCoeff(int n,int k){
        int c[][]=new int[n+1][k+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i,k); j++) {
                if (j==0 || j==i)
                    c[i][j]=1;
                else
                    c[i][j]=c[i-1][j-1]+c[i-1][j];
            }
        }

        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=k ; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }

        return c[n][k];
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println("Value of C("+n+","+k+") is "+binomialCoeff(n, k));
    }
}
