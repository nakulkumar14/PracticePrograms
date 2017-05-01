package com.practice;

/**
 * Created by nakul on 01-May-17.
 */
public class ProductOfArrayExceptSelf {

    static void productExtraSpace(int a[]){
        int left[]=new int[a.length];
        int right[]=new int[a.length];

        left[0]=right[a.length-1]=1;
        for (int i = 1; i < a.length; i++) {
            left[i]=left[i-1]*a[i-1];
        }

        for (int i = a.length-2; i >=0 ; i--) {
            right[i]=right[i+1]*a[i+1];
        }

        int result[]=new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i]=left[i]*right[i];
        }

        System.out.println("\nResult array extra space : ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");;
        }
    }

    static void productConstantSpace(int a[]){
        int result[]=new int[a.length];

        result[result.length-1]=1;
        for (int i = result.length-2; i >=0 ; i--) {
            result[i]=result[i+1]*a[i+1];
        }

        int left = 1;
        for (int i = 0; i < result.length; i++) {
            result[i]=result[i]*left;
            left=left*a[i];
        }

        System.out.println("\nResult array constant space : ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");;
        }
    }

    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        productExtraSpace(a);
        productConstantSpace(a);
    }
}
