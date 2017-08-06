package com.dp;

/**
 * Created by nakul on 5/8/17.
 *
 *
 * Subset sum problem
 */
public class SubsetSum {

    /**
     * Find subset with given sum recursively
     */
    static boolean subsetSumRecursive(int a[],int n, int sum){
        if (sum==0)
            return true;
        if (sum!=0 && n==0)
            return false;

        if (a[n-1] > sum)
            return subsetSumRecursive(a,n-1,sum);

        return subsetSumRecursive(a,n-1,sum) || subsetSumRecursive(a, n-1,sum-a[n-1]);
    }

    static void subsetSum(int a[],int sum){
        int s[][]=new int[sum+1][a.length+1];

        for (int i = 0; i < s[0].length; i++) {
            s[0][i] = 1;
        }

        for (int i = 1; i < s.length; i++) {
            s[i][0] = 0;
        }

        for (int i = 1; i < s.length; i++) {
            for (int j = 1; j < s[0].length; j++) {
                s[i][j]=s[i][j-1];
                if (i>=a[j-1]){
                    s[i][j]=s[i][j-1]==1?s[i][j-1]:s[i-a[j-1]][j-1];
                }

            }

        }

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                System.out.print(s[i][j]+" ");
            }
            System.out.println();

        }

        if (s[sum][a.length]==1)
            System.out.println("Sum found");
        else
            System.out.println("sum not found");

    }

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        if (subsetSumRecursive(set, set.length, 9) == true)
            System.out.println("Found subset with given sum");
        else
            System.out.println("No subset with given sum");

        System.out.println("Subset sum : ");
        subsetSum(set,9);
    }
}
