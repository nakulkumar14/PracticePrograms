package com.dp;

/**
 * Created by nakulkumar on 18/9/16.
 */
public class EditDistanceRecur {

    static int editDistance(String s1,String s2,int m,int n){
        if (m==0)
            return n;
        if (n==0)
            return m;

        if (s1.charAt(m)==s2.charAt(n))
            return editDistance(s1,s2,m-1,n-1);
        else{
            return 1+Math.min( editDistance(s1,s2,m,n-1), Math.min(editDistance(s1,s2,m-1,n),editDistance(s1,s2,m-1,n-1)));
        }
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println("Min distance : "+editDistance(str1,str2,str1.length()-1,str2.length()-1));
    }
}
