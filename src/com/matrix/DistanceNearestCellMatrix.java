package com.matrix;

// https://www.geeksforgeeks.org/distance-nearest-cell-1-binary-matrix/
// https://ide.geeksforgeeks.org/1mkft3

import java.util.LinkedList;

class Node {
    int i, j;
    int value;

    public Node(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }
}

public class DistanceNearestCellMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}
        };
        printMat(mat);
    }

    private static void printMat(int[][] a) {
        int[][] visited = new int[a.length][a[0].length];
        LinkedList<Node> queue = new LinkedList<>();

        // comment all 0's as they cannot be visited from their report.
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    visited[i][j] = 1;
                    queue.add(new Node(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();

            // check if node is safe to visit and not visited earlier
            if (isSafe(node, a, node.i + 1, node.j) && visited[node.i + 1][node.j] != 1 && a[node.i + 1][node.j] == 0) {
                visited[node.i + 1][node.j] = 1;
                a[node.i + 1][node.j] = node.value + 1;
                queue.add(new Node(node.i + 1, node.j, a[node.i + 1][node.j]));
            } else if (isSafe(node, a, node.i - 1, node.j) && visited[node.i - 1][node.j] != 1 && a[node.i - 1][node.j] == 0) {
                visited[node.i - 1][node.j] = 1;
                a[node.i - 1][node.j] = node.value + 1;
                queue.add(new Node(node.i - 1, node.j, a[node.i - 1][node.j]));
            } else if (isSafe(node, a, node.i, node.j + 1) && visited[node.i][node.j + 1] != 1 && a[node.i][node.j + 1] == 0) {
                visited[node.i][node.j + 1] = 1;
                a[node.i][node.j + 1] = node.value + 1;
                queue.add(new Node(node.i, node.j + 1, a[node.i][node.j + 1]));
            } else if (isSafe(node, a, node.i, node.j - 1) && visited[node.i][node.j - 1] != 1 && a[node.i][node.j - 1] == 0) {
                visited[node.i][node.j - 1] = 1;
                a[node.i][node.j - 1] = node.value + 1;
                queue.add(new Node(node.i, node.j - 1, a[node.i][node.j - 1]));
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }

    }

    private static boolean isSafe(Node node, int[][] a, int i, int j) {
        return i >= 0 && i < a.length && j >= 0 && j < a[0].length;
    }
}
