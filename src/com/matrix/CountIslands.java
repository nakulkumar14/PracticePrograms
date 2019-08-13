package com.matrix;

// https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
public class CountIslands {
    public static void main(String[] args) {
        int list[][] = {
                {1, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 1}};

        // creating arraylist of arraylist
        System.out.println(findIslands(list, 4, 7));

        int a[][] = {
                {1, 1, 0}, {0, 0, 1}, {1, 0, 1}
        };
        System.out.println(findIslands(a, 3, 3));
    }

    static boolean isSafe(int i, int j, int N, int M, boolean visited[][]) {
        return i >= 0 && i < N && j >= 0 && j < M && !visited[i][j];
    }

    static void findUtil(int[][] list, int i, int j, int N, int M, boolean visited[][]) {
        visited[i][j] = true;
        int r[] = {0, 0, 1, -1, -1, 1, -1, 1};
        int c[] = {1, -1, 0, 0, -1, -1, 1, 1};

        for (int k = 0; k < 8; k++) {
            int x = i + r[k];
            int y = j + c[k];
//            System.out.println(i + " " + j);
//            System.out.println(x + " " + y);
            if (isSafe(x, y, N, M, visited) && list[x][y] == 1) {
                findUtil(list, x, y, N, M, visited);
            }
        }

    }

    static int findIslands(int[][] list, int N, int M) {

        // Your code here
        if (N <= 0 || M <= 0 || list.length == 0) {
            return 0;
        }

        boolean visited[][] = new boolean[N][M];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (list[i][j] == 1 && !visited[i][j]) {
                    count++;
                    findUtil(list, i, j, N, M, visited);
                    show(visited);
                }
            }
        }

        return count;
    }

    private static void show(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j] ? 1 : 0);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("========");
    }
}
