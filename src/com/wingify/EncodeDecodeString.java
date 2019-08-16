package com.wingify;

import java.util.Scanner;

/**
 * Write a program to encode and decode a string.
 * <p>
 * Logic for encoding is:
 * For a single occurrence of a characters, let's say A is there 1 time, the encode should be B (A+1) where 1 is the number of occurrence. Had it been 2 occurrences, the logic would have been A+2 = C.
 * <p>
 * Encoding:
 * Input: WIINNNGGIIFFFFFFFYYYY
 * Output: XK2Q3I2K2M7C4
 * <p>
 * Decoding:
 * Input: XK2Q3I2K2M7C4
 * Output: WIINNNGGIIFFFFFFFYYYY
 */
public class EncodeDecodeString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String output = "";
        char ch;
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            System.out.println("char: " + ch + ", i : " + i);
            c = 1;
            int j = i + 1;
            while (j < s.length() && ch == s.charAt(j)) {
                c++;
                j++;
                i++;
            }
            System.out.println("char: " + ch + ", i : " + i + ", c: " + c);
            if (ch + c > 'Z')
                output += ((char) (ch + c - 1 - 'Z' + 'A'));
            else
                output += ((char) (ch + c));
            if (c > 1)
                output += "" + c;
        }
        System.out.println(output);
        System.out.println(s);
    }
}
