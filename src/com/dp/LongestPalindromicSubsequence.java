package com.dp;

/**
 * Created by nakulkumar on 1/10/16.
 */
public class LongestPalindromicSubsequence {

    static int lps(String s){
        int tab[][]=new int[s.length()][s.length()];

        // length 1 string are palindromes
        for (int i = 0; i < s.length(); i++) {
            tab[i][i]=1;
        }

        for (int k = 2;k<=s.length();++k){
            for (int i = 0; i < s.length()-k+1; i++) {
                int j = i+k-1;
                if (s.charAt(i)==s.charAt(j) && k==2){
                    tab[i][j]=2;
                }else if (s.charAt(i)==s.charAt(j)){
                    tab[i][j]=tab[i+1][j-1]+2;
                }else
                    tab[i][j]=Math.max(tab[i+1][j],tab[i][j-1]);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                System.out.print(tab[i][j]+" ");
            }
            System.out.println();
        }

        return tab[0][s.length()-1];
    }

    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        System.out.println("The lnegth of the lps is "+ lps(seq));
    }
}
