package com.practice;

import java.util.Arrays;

/**
 * Created by nakul on 17-Dec-16.
 */
public class PrintAllPaths {

    private static void printAllPaths(int[][] mat, int m, int n) {
        int path[] = new int[m+n];
        printAllPathsUtil(mat,m,n,0,0,path,0);
    }

    private static void printAllPathsUtil(int[][] mat, int m, int n, int i, int j, int[] path, int p) {
        if (i==m-1 && j==n-1){
            for (int k = 0; k < path.length; k++) {
                System.out.print(path[k]+" ");
            }
            System.out.println();
            return;
        }

        if (i==m-1){
            for (int k = j; k < n; k++) {
                path[p++]=mat[m-1][k];
            }

            for (int k = 0; k < path.length; k++) {
                if (k==m+n-1)
                    break;
                System.out.print(path[k]+" ");
            }
            System.out.println();
            return;
        }

        if (j==n-1){
            for (int k = i; k < m; k++) {
                path[p++]=mat[k][n-1];
            }

            for (int k = 0; k < path.length; k++) {
                if (k==m+n-1)
                    break;
                System.out.print(path[k]+" ");
            }
            System.out.println();;
            return;
        }


        path[p]=mat[i][j];
        printAllPathsUtil(mat,m,n,i+1,j,path,p+1);
        printAllPathsUtil(mat,m,n,i,j+1,path,p+1);

    }

    public static void main(String[] args) {
        int mat[][] = { {1, 2, 3}, {4, 5, 6} };
        printAllPaths(mat,2,3);
    }


}
