package com.lendingkart;

public class TestClass {

    static String numAndString(int n,int k){
        String str = "0abcdefghijklmnopqrstuvwxyz";
        if (k<26){
            String res = "" + str.charAt(26-n);
            n--;
            k = 26-k+1;
            while(n!=0 && k!=0){
                int pos = k-n+1;
                res = str.charAt(pos) + res;
                k = k-pos;
                n--;
            }
            return res;
        }else{
            String res = "z";
            n--;
            k = k-26;
            while(k!=0 && n!=0){
                int pos = k-n+1;
                res = str.charAt(pos) + res;
                k=k-pos;
                n--;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(numAndString(5,42));
        System.out.println(numAndString(3,25));
    }
}
