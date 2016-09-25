package com.dp;

/**
 * Created by nakul on 25-Sep-16.
 */
public class Knapsack01 {

    static int knapSack(int W,int wt[],int val[]){
        int tab[][]= new int[val.length+1][W+1];

        for (int i = 0; i <=val.length ; i++) {
            for (int j = 0; j <=W ; j++) {
                if (i==0 || j==0)
                    tab[i][j]=0;
                else if (wt[i-1]<=j)
                    tab[i][j]=Math.max(val[i-1]+tab[i-1][j-wt[i-1]],tab[i-1][j]);
                else
                    tab[i][j]=tab[i-1][j];
            }
        }

        return tab[val.length][W];
    }

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        System.out.println(knapSack(W, wt, val));
    }

}
