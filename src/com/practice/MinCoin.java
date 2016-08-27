package com.practice;

import java.util.Arrays;

/* Name of the class has to be "Main" only if the class is public. */
public class MinCoin
{
    static int floor(int coins[],int item){

        if (item>=coins[coins.length-1])
            return coins[coins.length-1];

        for (int i=0;i<coins.length;i++){
            if (coins[i]==item)
                return item;
            if (i+1<coins.length-1 && coins[i]<=item && coins[i+1]>item)
                return coins[i];
        }

        return -1;
    }

    static int minCoins(int coins[],int V){
        Arrays.sort(coins);
        int count=0;
        while(V!=0){
            int ceiling  = floor(coins,V);
            if(ceiling>0){
                V=V-ceiling;
                count++;
            }else{
                V=V-coins[coins.length-1];
                count++;
            }
        }
        return count;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        int coins[] =  {9, 6, 5, 1};
        int V = 11;
        System.out.println("Minimum coins : "+minCoins(coins,V));
    }
}