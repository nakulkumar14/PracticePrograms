package com.goldman;

public class CountTriangles {

    public static int countPossibleTriangles(int A, int P, int a) {
        int sum = P - a;
        int i = 1;
        int j = 1000;

        int s1, s2;
        int count = 0;

        while (i <= j) {
            if (i + j == sum) {

                s1 = i;
                s2 = j;
                if (s1 + s2 + a == P && calculateArea(A, s1, s2, a, (double) P / 2)) {
                    count++;
                }

                i++;
                j--;
            } else if (i + j < sum) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }

    static boolean calculateArea(int A, int a, int b, int c, double s) {
        return A * A <= (s * (s - a) * (s - b) * (s - c));
    }

    public static void main(String[] args) {
        System.out.println(countPossibleTriangles(10, 15, 5));
    }
}
