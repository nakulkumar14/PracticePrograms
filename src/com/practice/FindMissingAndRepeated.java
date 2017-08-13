package com.practice;

/**
 * Created by nakul on 13/8/17.
 */
public class FindMissingAndRepeated {
    public static void main(String[] args) {
        int a[] = {1,2,2,4};
        int n = 4;

        int setbit = 0;
        for (int i = 0; i < a.length; i++) {
            setbit = setbit^a[i];
        }

        for (int i = 1; i <=n; i++) {
            setbit = setbit^i;
        }

        System.out.println("setbit : "+setbit);

        int lastbit = setbit & ~(setbit-1);

        int x=0,y=0;
        for (int i = 0; i < a.length; i++) {
            if ((lastbit & a[i])==1)
                x=x^a[i];
            else
                y=y^a[i];
            System.out.println("i : "+i);
            System.out.println("x : "+x);
            System.out.println("y : "+y);
        }

        for (int i = 1; i <=n; i++) {
            if ((lastbit & i)==1)
                x=x^i;
            else
                y=y^i;
            System.out.println("i : "+i);
            System.out.println("x : "+x);
            System.out.println("y : "+y);
        }

        System.out.println("x : "+x+", y : "+y);
    }
}
