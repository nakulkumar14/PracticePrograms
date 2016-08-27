package com.practice;

public class LongestPalindrome1 {

    static boolean isPalindrome(String s) {
        int l=0,h=s.length()-1;
        while (l<=h){
            if (s.charAt(l)!=s.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }

    static void longestPalindrome(String s) {
        int maxlength = 0;
        String p = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j=i+1;j<=s.length()-i;++j){
                System.out.println(s.substring(i,j));
                String temp = s.substring(i,j);
                if (isPalindrome(temp) && temp.length() > maxlength) {
                    maxlength = temp.length();
                    p = temp;
                }
            }
        }

        System.out.println("Longest palindrome : "+p);
    }

    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        longestPalindrome(s);
    }
}
