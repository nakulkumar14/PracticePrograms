package com.strings;

import java.util.*;

// https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
// https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
public class PrintAnagramsTogether {

    public static void main(String[] args) {
        String wordArr[] = {"cat", "dog", "tac", "god", "act", "gdo"};
        printAnagrams(wordArr);
    }

    private static void printAnagrams(String[] wordArr) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>(Arrays.asList(wordArr));
        list.forEach(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(word);
            } else {
                List<String> values = new ArrayList<>();
                values.add(word);
                map.put(sortedWord, values);
            }
        });

        map.forEach((k, v) -> System.out.print(v));
    }
}
