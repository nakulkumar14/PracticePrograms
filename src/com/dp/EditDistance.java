package com.dp;

/**
 * Created by nakulkumar on 18/9/16.
 */
public class EditDistance {

    static int editDistance(String s1,String s2){
        int table[][]=new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i==0)
                    table[i][j]=j;
                else if (j==0)
                    table[i][j]=i;
                else if (s1.charAt(i-1)==s2.charAt(j-1))
                    table[i][j]=table[i-1][j-1];
                else{
                    table[i][j]=1+Math.min(table[i][j-1],Math.min(table[i-1][j],table[i-1][j-1]));
                }
            }
        }

//        for (int i = 0; i <= s1.length(); i++) {
//            for (int j = 0; j <= s2.length(); j++) {
//                System.out.print(table[i][j]);
//            }
//            System.out.println();
//        }

        return table[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println("Edit distance : "+editDistance(str1,str2));
    }
}
