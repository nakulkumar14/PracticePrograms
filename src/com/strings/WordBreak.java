package com.strings;

import java.util.HashSet;
import java.util.Set;

// https://www.geeksforgeeks.org/word-break-problem-using-backtracking/}
public class WordBreak {

    static Set<String> dictionary = new HashSet<>();

    static {
        String arr[] = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "love", "ice", "cream", "like"};
        for (int i = 0; i < arr.length; i++) {
            dictionary.add(arr[i]);
        }
    }

    static void wordBreak(String s) {
        wordBreakUtil(s, s.length(), "");
    }

    static void wordBreakUtil(String s, int len, String result) {

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dictionary.contains(prefix)) {
                if (i == s.length()) {
                    result += prefix;
                    System.out.println(result);
                }
                wordBreakUtil(s.substring(i), s.length() - i, result + prefix + " ");
            }
        }

    }


    public static void main(String[] args) {
        wordBreak("iloveicecreamandmango");
        wordBreak("ilikesamsungmobile");
    }
}
