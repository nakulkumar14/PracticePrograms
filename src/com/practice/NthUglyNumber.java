package com.practice;

/**
 * Created by nakul on 30/7/17.
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        int no = getNthUglyNo(150);
        System.out.println("150th ugly no. is "+ no);
    }

    static int getNthUglyNo(int n) {
        int i = 1, count = 1;
        while (n > count){
            i++;
            if (isUgly(i))
                count++;
        }

        return i;
    }

    static boolean isUgly(int n) {
        n = maxDivide(n, 2);
        n = maxDivide(n, 3);
        n = maxDivide(n, 5);

        return n == 1?true:false;
    }

    static int maxDivide(int a, int b) {
        while (a%b==0)
            a=a/b;
        return a;
    }
}
