package com.practice;

/**
 * Created by nakul on 05-Mar-17.
 * reverse words in a string.
 */
class ReverseWordsInString
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        String s = "the true hero is there, he is the batman";

        String res = "";

        while(s.length()!=0){
            int x = s.indexOf(' ');
            if(x!=-1){
                res=s.substring(0,x)+" "+res;
                s=s.substring(x+1);
            }else{
                res=s.substring(0)+" " + res;
                s="";
            }
        }

        System.out.println("s: "+s+", res : "+res);
    }
}
