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
        printMatrix(mat, m, n, 0, 0, new int[maxLengthOfPath], 0);
    }

    private static void printMatrix(int[][] mat, int m, int n, int i, int j, int[] path, int idx) {
        path[idx] = mat[i][j];
        if (i == m - 1) {
            for (int k = j + 1; k < n; k++) {
                path[idx + k - j] = mat[i][k];
            }
            System.out.println(Arrays.toString(path));
            return;
        }
        if (j == n - 1) {
            for (int k = i + 1; k < m; k++) {
                path[idx + k - i] = mat[k][j];
            }

            System.out.println(Arrays.toString(path));
            return;
        }
        printMatrix(mat, m, n, i, j + 1, path, idx + 1);
        printMatrix(mat, m, n, i + 1, j, path, idx + 1);
//        printMatrix(mat, m, n, i + 1, j + 1, path, idx + 1);
    }
}
