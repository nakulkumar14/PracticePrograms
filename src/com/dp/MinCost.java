package com.dp;

/**
 * Created by nakulkumar on 18/9/16.
 */
public class MinCost {

    static int minCost(int cost[][]){
        int table[][]=new int[cost.length][cost[0].length];

        table[0][0]=cost[0][0];
        for (int i = 1; i <cost.length; i++) {
            table[i][0]=table[i-1][0]+cost[i][0];
        }

        for (int i = 1; i <cost[0].length; i++) {
            table[0][i]=table[0][i-1]+cost[0][i];
        }

        for (int i = 1; i < cost.length; i++) {
            for (int j = 1; j < cost[0].length; j++) {
                table[i][j]=cost[i][j]+Math.min(table[i-1][j-1],Math.min(table[i-1][j],table[i][j-1]));
            }
        }

        return table[cost.length-1][cost[0].length-1];
    }

    public static void main(String[] args) {
        int cost[][] = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3}
                          };
        System.out.println("Min cost : "+minCost(cost));
    }
}
