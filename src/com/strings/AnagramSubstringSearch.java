package com.strings;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
public class AnagramSubstringSearch {

    static void printPositions(char c1[], char c2[]){

        List<Integer> result = new ArrayList<>();

        int countT[] = new int[256];
        int countW[] = new int[256];

        // count of characters of pattern.
        for (int i = 0; i < c2.length; i++) {
            countT[c2[i]]++;
            countW[c1[i]]++;
        }

        for (int i = c2.length; i < c1.length ; i++) {
            // compare the count of current window to pattern window.
            if (compare(countT, countW)){

                // print starting index of window.
                result.add(i - c2.length);
//                System.out.println(i-c2.length);
            }

            // remove first character of window.
            countW[c1[i-c2.length]]--;
            // add new character to window.
            countW[c1[i]]++;
        }
        // compare the last window.
        if (compare(countT, countW)){
            result.add(c1.length - c2.length);
//            System.out.println(c1.length-c2.length);
        }
        System.out.println(result);
        
    }

    // compare takes constant time as character size limit is fixed.
    private static boolean compare(int[] countT, int[] countW) {
        for (int i = 0; i < countT.length; i++) {
            if (countT[i]!=countW[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s1 = "BACDGABCDA";
        String s1 = "AAABABAA";
//        String s2 = "ABCD";
        String s2 = "AABA";
        printPositions(s1.toCharArray(), s2.toCharArray());

        printPositions("baa".toCharArray(), "aa".toCharArray());
        printPositions("cbaebabacd".toCharArray(), "abc".toCharArray());
        printPositions("aaaaaaaaaa".toCharArray(), "aaaaaaaaaaaaa".toCharArray());

    }
}
