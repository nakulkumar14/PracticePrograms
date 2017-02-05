package com.practice;

import java.util.Arrays;

/**
 * Created by nakul on 05-Feb-17.
 * Find the longest substring with k unique characters in a given string
 * Given a string you need to print longest possible substring that has
 * exactly M unique characters. If there are more than one substring of longest
 * possible length, then print any one of them.
 */
public class LongestSubstringWithKUniqueCharacters {

    static void kUniques(String s,int k){
        int c[]=new int[256];
        int u=0;
        for (int i = 0; i < s.length(); i++) {
            if (c[s.charAt(i)-'a']==0)
                u++;
            c[s.charAt(i)-'a']++;
        }

        if (u<k){
            System.out.println("Not enough unique characters");
            return;
        }

        // Clears c(count) array.
        Arrays.fill(c,0);

        int maxstart=0,maxlen=1;
        int cstart=0,cend=0;

        c[s.charAt(0)-'a']++;

        for (int i = 1; i < s.length(); i++) {
            c[s.charAt(i)-'a']++;
            cend++;

            // remove characters from left if found more than k.
            while (!isValid(c,k)){
                c[s.charAt(cstart)-'a']--;
                cstart++;
            }

            if (maxlen < cend-cstart+1){
                maxlen = cend-cstart+1;
                maxstart=cstart;
            }
        }

        System.out.println("Substring  : " + s.substring(maxstart,maxstart+maxlen));

    }

    // counts unique characters found so far
    private static boolean isValid(int[] c, int k) {
        int val=0;
        for (int i = 0; i < c.length; i++) {
            if (c[i]>0)
                val++;
        }

        return k>=val;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        //s = "kannan";k=2;
        kUniques(s, k);
    }
}
