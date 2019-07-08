package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem-set-2-hashmap/
public class NutsAndBolts {

    static void sort(char nuts[], char bolts[]) {

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < nuts.length; i++) {
            map.put(nuts[i], i);
        }

        for (int i = 0; i < bolts.length; i++) {
            if (map.containsKey(bolts[i])) {
                nuts[i] = bolts[i];
            }
        }

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }

    public static void main(String[] args) {
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
        sort(nuts, bolts);
    }
}
