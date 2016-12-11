package com.practice;

/**
 * Created by nakul on 11-Dec-16.
 */
public class ReverseString {

    static String reverse(String s){
        String res="";

        String word="";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=' '){
                word = word +s.charAt(i);
            }
            else{
                res = word + " " + res;
                word = "";
            }
        }
        res  = word + " " + res;

        return res;
    }

    public static void main(String[] args) {
        String s = "much very program this like i";
        System.out.println(reverse(s));
    }
}
