package com.matrix;

import java.util.Arrays;

// https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
public class PrintAllPathsInMatrix {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int mat[][] = {{1, 2, 3},
                {4, 5, 6}};
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        System.out.println();

        int maxLengthOfPath = m + n - 1;
        String s = "";
        printMatrix(mat, m, n, 0, 0, new int[maxLengthOfPath], 0, s);
    }

    private static void printMatrix(int[][] mat, int m, int n, int i, int j, int[] path, int idx, String s) {
        path[idx] = mat[i][j];
        s += "(" + i + "," + j + ")";
        if (i == m - 1) {
            for (int k = j + 1; k < n; k++) {
                path[idx + k - j] = mat[i][k];
                s += "(" + i + "," + k + ")";
            }
//            System.out.println( "s : " + s);

            for (int l = 0; l < idx + n - j; l++) {
                System.out.print(path[l] + " ");
            }
            System.out.println();

            return;
        }
        if (j == n - 1) {
            for (int k = i + 1; k < m; k++) {
                path[idx + k - i] = mat[k][j];
                s += "(" + k + "," + j + ")";
            }

//            System.out.println( "s : " + s);

            for (int l = 0; l < idx + m - i; l++) {
                System.out.print(path[l] + " ");
            }
            System.out.println();

            return;
        }
        printMatrix(mat, m, n, i, j + 1, path, idx + 1, s);
        printMatrix(mat, m, n, i + 1, j, path, idx + 1, s);
        printMatrix(mat, m, n, i + 1, j + 1, path, idx + 1, s);
    }
}
