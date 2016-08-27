package com.practice;

/**
 * Created by nakulkumar on 27/8/16.
 */
public class LongestPalindrome2 {

    static void longestPalinedrome(String s){
        int table[][]=new int[s.length()][s.length()];

        // string of size 1 are palindromes
        int maxlength = 1;
        for (int i = 0; i < s.length(); i++) {
            table[i][i]=1;
        }

        // check for string of size 2
        int start=0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i)==s.charAt(i+1)){
                table[i][i+1]=1;
                start=i;
            }
        }

        // check for strings greater than length 2.
        for (int k = 3; k < s.length(); k++) {
            for (int i = 0; i < s.length() - k + 1; i++) {
                int j = i+k-1;
                if (table[i+1][j-1]==1 && s.charAt(i)==s.charAt(j)){
                    table[i][j]=1;
                    if (k>maxlength){
                        maxlength=k;
                        start=i;
                    }
                }
            }
        }

        System.out.println("Maxlength : "+maxlength);
        System.out.println(s.substring(start,start+maxlength));
    }

    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        longestPalinedrome(s);
    }
}
