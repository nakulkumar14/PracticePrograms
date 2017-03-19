package com.practice;

/**
 * Created by nakul on 19-Mar-17.
 */
public class MajorityElement {

    static void printMajority(int a[]){
        int ele = findMajority(a);

        if (isMajority(a, ele)){
            System.out.println("Majority element : "+ele);
        }
        else{
            System.out.println("No majority element");
        }
    }

    static boolean isMajority(int a[],int ele) {
        int count=0;
        for (int i = 0; i < a.length; i++) {
            if (ele==a[i])
                count++;
        }

        return count>a.length/2;
    }

    static int findMajority(int[] a) {
        int maj = 0;
        int count =1;
        for (int i = 1; i < a.length; i++) {
            if (a[i]==a[count])
                count++;
            else
                count--;

            if (count==0){
                maj=i;
                count=1;
            }
        }

        return a[maj];
    }

    public static void main(String[] args) {
//        int a[] = {2, 2, 3, 5, 2, 2, 6};
        int a[] = {1, 3, 3, 1, 2};
        printMajority(a);
    }
}
