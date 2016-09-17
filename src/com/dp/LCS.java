package com.dp;

/**
 * Created by nakulkumar on 17/9/16.
 */
public class LCS {
    static int lcs(char x[],char y[]){
        int temp[][]=new int[x.length+1][y.length+1];

        for (int i = 0; i <= x.length; i++) {
            for (int j = 0; j <= y.length; j++) {
                if (i==0 || j==0)
                    temp[i][j]=0;
                else if (x[i-1]==y[j-1])
                    temp[i][j]=temp[i-1][j-1]+1;
                else
                    temp[i][j]=Math.max(temp[i-1][j],temp[i][j-1]);
            }
        }

        String str="";
        int k=0;
        int i=x.length,j=y.length;
        while (i>0 && j>0){
            if (x[i-1]==y[j-1]) {
                str += x[i - 1];
                i--;
                j--;
            }else if(temp[i-1][j]>temp[i][j-1])
                i--;
            else
                j--;
        }
        System.out.println("LCS : "+new StringBuffer(str).reverse());

        return temp[x.length][y.length];
    }
    public static void main(String[] args) {
        char[] X = new char[]{'A', 'G','G','T','A','B'};
        char[] Y = new char[]{'G','X','T','X','A','Y','B'};
        System.out.println("Length of lcs is : "+lcs(X,Y));
    }
}
