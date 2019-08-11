package com.matrix;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/unique-paths-in-a-grid-with-obstacles/
// https://www.geeksforgeeks.org/shortest-distance-two-cells-matrix-grid/

public class UniquePathsInMatrix {

    public static void main(String[] args) {
        char grid[][] = {
                {'0', '1', '0', 's'},
                {'1', '0', '1', '1'},
                {'0', '1', '1', '1'},
                {'d', '1', '1', '1'}
        };
//        System.out.println("Result : " + minDistance(grid));

        char a[][] = {
                {'0', '1', '0', 's'},
                {'1', '0', '1', '1'},
                {'0', '1', '1', '1'},
                {'d', '0', '0', '0'}
        };
//        System.out.println("Result : " + minDistance(a));

        char b[][] = {
                {'s', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', 'd', '0'}
        };
        System.out.println("Result : " + minDistance(b));

        char c[][] = {
                {'0', 's'},
                {'d', '0'}
        };
//        System.out.println("Result : " + minDistance(c));
    }

    private static int minDistance(char[][] a) {
        String s = "";
        boolean visited[][] = new boolean[a.length][a[0].length];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 's') {
                    visited[i][j] = true;
                    q.add(new Node(i, j, 0));
                    break;
                } else if (a[i][j] == '0') {
                    visited[i][j] = true;
                }
            }
        }


        while (!q.isEmpty()) {
            Node node = ((LinkedList<Node>) q).removeLast();

            if (isSafe(node.i + 1, node.j, a) && !visited[node.i + 1][node.j]) {

                if (a[node.i + 1][node.j] == '1') {
                    a[node.i + 1][node.j] = (char) (node.value + 1);
                } else if (a[node.i + 1][node.j] == 'd') {
                    s += " (" + node.i + ", " + node.j + ")";
                    s += " (" + (node.i + 1) + ", " + node.j + ")";
                    System.out.println(s);
                    return (node.value + 1);
                }

                visited[node.i + 1][node.j] = true;
                ((LinkedList<Node>) q).addLast(new Node(node.i + 1, node.j, node.value + 1));
            }

            if (isSafe(node.i - 1, node.j, a) && !visited[node.i - 1][node.j]) {

                if (a[node.i - 1][node.j] == '1') {
                    a[node.i - 1][node.j] = (char) (node.value + 1);
                } else if (a[node.i - 1][node.j] == 'd') {
                    s += " (" + node.i + ", " + node.j + ")";
                    s += " (" + (node.i - 1) + ", " + node.j + ")";
                    System.out.println(s);
                    return (node.value + 1);
                }


                visited[node.i - 1][node.j] = true;
                ((LinkedList<Node>) q).addLast(new Node(node.i - 1, node.j, node.value + 1));
            }

            if (isSafe(node.i, node.j + 1, a) && !visited[node.i][node.j + 1]) {

                if (a[node.i][node.j + 1] == '1') {
                    a[node.i][node.j + 1] = (char) (node.value + 1);
                } else if (a[node.i][node.j + 1] == 'd') {
                    s += " (" + node.i + ", " + node.j + ")";
                    s += " (" + node.i + ", " + (node.j + 1) + ")";
                    System.out.println(s);
                    return (node.value + 1);
                }

                visited[node.i][node.j + 1] = true;
                ((LinkedList<Node>) q).addLast(new Node(node.i, node.j + 1, node.value + 1));
            }

            if (isSafe(node.i, node.j - 1, a) && !visited[node.i][node.j - 1]) {

                if (a[node.i][node.j - 1] == '1') {
                    a[node.i][node.j - 1] = (char) (node.value + 1);
                } else if (a[node.i][node.j - 1] == 'd') {
                    s += " (" + node.i + ", " + node.j + ")";
                    s += " (" + node.i + ", " + (node.j - 1) + ")";
                    System.out.println(s);
                    return (node.value + 1);
                }

                visited[node.i][node.j - 1] = true;
                ((LinkedList<Node>) q).addLast(new Node(node.i, node.j - 1, node.value + 1));
            }

            s += " (" + node.i + ", " + node.j + ")";
        }
        return Integer.MIN_VALUE;
    }

    static boolean isSafe(int i, int j, char a[][]) {
        return i >= 0 && i < a.length && j >= 0 && j < a[0].length;
    }

    static class Node {
        int i;
        int j;
        int value;

        public Node(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}
