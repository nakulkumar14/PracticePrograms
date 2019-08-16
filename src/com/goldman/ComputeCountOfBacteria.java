package com.goldman;

public class ComputeCountOfBacteria {

    public static long computeCount(int m, int n) {
        int mat[][] = new int[m][n];
        mat[m - 1][0] = 1;

        int r[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int c[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < 8; k++) {
                    dfs(i + r[k], j + c[k], m, n, mat);
                }

                mat[i][j]--;
            }
        }
        return mat[m - 1][n - 1];
    }

    static void dfs(int i, int j, int m, int n, int mat[][]) {
        if (i < m && i >= 0 && j < n && j >= 0) {
            mat[i][j]++;
        }
    }

    public static void main(String[] args) {
        System.out.println(computeCount(4, 3));
    }
}
