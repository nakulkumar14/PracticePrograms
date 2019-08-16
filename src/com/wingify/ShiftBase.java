package com.wingify;

import java.util.Scanner;

/**
 * Write a program 'shiftBase', that takes two numbers as parameters: the number (in decimal)
 * to shift, and the base of the new number system, which may range from 1 to 64,
 * and returns the string representation of the number in the new number system.
 * In a base 64 number system, the numbers may be represented in the following way:
 * <p>
 * 0 - 9 = Numbers
 * 10 - 35 = Lowercase alphabets (a-z)
 * 36 - 61 = Uppercase alphabets (A-Z)
 * 62 = Underscore (_)
 * 63 = Hyphen(-)
 * <p>
 * Example:
 * shiftBase(15, 16) // f
 * shiftBase(16, 16) // 10
 * shiftBase(255, 16) // ff
 * shiftBase(63, 64) // -
 * shiftBase(4095, 64) // --
 * shiftBase(35, 36) // z
 * shiftBase(36, 36) // 10
 * shiftBase(8, 8) // 10
 * shiftBase(63, 8) // 77
 */
public class ShiftBase {

    static String shiftBase(int num, int base) {
        if (num == base)
            return 10 + "";
        if (base == 16) {
            if (num < 10)
                return num + "";

            String r = "";
            int rem;
            if (num > 15) {
                rem = num % base;
                r = "f";
            } else {
                rem = num;
            }

            if (rem == 10)
                r += "a";
            else if (rem == 11)
                r += "b";
            else if (rem == 12)
                r += "c";
            else if (rem == 13)
                r += "d";
            else if (rem == 14)
                r += "e";
            else if (rem == 15)
                r += "f";
            return r;
        }

        if (base == 36) {
            if (num < 10)
                return num + "";

            String r = "";
            int rem;

            if (num >= 10 && num < 36) {
                r = num - 10 + "a";
                return r;
            }

            if (num > 35) {
                rem = num % base;
                r = "f";
            } else {
                rem = num;
            }

            if (rem == 10)
                r += "a";
            else if (rem == 11)
                r += "b";
            else if (rem == 12)
                r += "c";
            else if (rem == 13)
                r += "d";
            else if (rem == 14)
                r += "e";
            else if (rem == 15)
                r += "f";
            return r;
        }


        return "";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int base = in.nextInt();
//        System.out.println(63%8);
        String result = shiftBase(num, base);
        System.out.println(result);
    }
}
