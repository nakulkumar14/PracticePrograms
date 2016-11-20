package com.dp;

/**
 * Created by nakul on 25-Sep-16.
 *
 * Longest Palindromic Subsequence
 */
public class LPS {

    static int lps(String s){
        int tab[][]=new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            tab[i][i]=1;
        }

        for (int cl = 2; cl <=s.length() ; cl++) {
            for (int i = 0; i < s.length()-cl+1; i++) {
                int j = i+cl-1;

                if (cl==2 && s.charAt(i)==s.charAt(j))
                    tab[i][j]=2;
                else if (s.charAt(i)==s.charAt(j))
                    tab[i][j]=tab[i+1][j-1]+2;
                else
                    tab[i][j]=Math.max(tab[i+1][j],tab[i][j-1]);
            }
        }

        for (int i = 0; i <s.length() ; i++) {
            for (int j = 0; j <s.length() ; j++) {
                System.out.print(tab[i][j]+" ");
            }
            System.out.println();
        }

        return tab[0][s.length()-1];
    }

    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        System.out.println("The length of the lps is "+ lps(seq));
    }
}
