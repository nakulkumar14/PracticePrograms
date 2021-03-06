package com.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a valid sentence without any spaces between the words
 * and a dictionary of valid English words, find all possible ways
 * to break the sentence in individual dictionary words.
 */
public class WordBreak {

    Set<String> set = new HashSet<>();

    void createDictionary() {
        String words[] = {"mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "love",
                "ice", "cream"};

        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
    }

    boolean wordBreak(String s) {

        // If string is empty return true.
        if (s.length() == 0)
            return true;

        for (int i = 1; i <= s.length(); i++) {
            // Check if word is present, if so check if rest of the string can be broken into words.
            boolean isWordPresent = set.contains(s.substring(0, i));
            if (isWordPresent && wordBreak(s.substring(i))) {
                return true;
            }
        }

        return false;
    }

    // Work break problem using DP.
    boolean wordBreakDP(String s) {
        boolean wb[] = new boolean[s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            if (wb[i] == false && set.contains(s.substring(0, i))) {
                wb[i] = true;
            }

            if (wb[i]) {
                if (i == s.length())
                    return true;

                for (int j = i + 1; j <= s.length(); j++) {
                    if (wb[j] == false && set.contains(s.substring(i, Math.min(i + (j - i), s.length()))))
                        wb[j] = true;

                    if (j == s.length() && wb[j] == true)
                        return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();

        wordBreak.createDictionary();

        System.out.println(wordBreak.wordBreak("iloveicecreamandmango"));
        System.out.println(wordBreak.wordBreakDP("iloveicecreamandmango"));

        System.out.println(wordBreak.wordBreak("ilovesamsungmobile"));
        System.out.println(wordBreak.wordBreakDP("ilovesamsungmobile"));
    }

}
