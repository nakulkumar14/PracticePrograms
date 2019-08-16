package com.practice;

public class PowerOfNumber {

    static int power(int a, int b) {
        if (b == 1)
            return a;

        int pw = 1;
        for (int i = 1; i <= b; i++) {
            pw *= a;
        }

        int inc = a;
        int a1 = a;
        for (int i = 1; i < b; i++) {
            for (int j = 1; j < a1; j++) {
                inc += a;
            }
            a = inc;
        }

        System.out.println(inc);

        return pw;
    }

    static int pow(int a, int b) {
        if (b > 0)
            return mul(a, pow(a, b - 1));
        return 1;
    }

    static int mul(int a, int b) {
        if (b > 0)
            return (a + mul(a, b - 1));
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 3));
        System.out.println(pow(2, 3));
        System.out.println(power(5, 3));
        System.out.println(pow(5, 3));
        System.out.println(power(4, 3));
        System.out.println(pow(4, 3));
    }
}
