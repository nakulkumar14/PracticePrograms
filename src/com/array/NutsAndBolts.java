package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem-set-2-hashmap/
public class NutsAndBolts {

    static void matchPairs(char nuts[], char bolts[], int l, int h) {
        if (l < h) {
            int pivot = partition(nuts, l, h, bolts[h]);

            partition(bolts, l, h, nuts[pivot]);

            matchPairs(nuts, bolts, l, pivot - 1);
            matchPairs(nuts, bolts, pivot + 1, h);
        }
    }

    static int partition(char[] a, int l, int h, char pivot) {
        int i = l;
        for (int j = l; j < h; j++) {
            if (a[j] < pivot) {
                char temp = a[i];
                a[j] = a[i];
                a[i] = temp;
                i++;
            } else if (a[j] == pivot) {
                char temp = a[h];
                a[h] = a[j];
                a[j] = temp;
                j--;
            }
        }

        char temp = a[i];
        a[i] = a[h];
        a[h] = temp;

        return i;
    }


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
//        sort(nuts, bolts);
        matchPairs(nuts, bolts, 0, nuts.length - 1);

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }
}
