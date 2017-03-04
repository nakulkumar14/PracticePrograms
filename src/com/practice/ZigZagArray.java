package com.practice;

/**
 * Created by nakul on 04-Mar-17.
 * Convert array into Zig-Zag fashion
 * Given an array of distinct elements,
 * rearrange the elements of array in zig-zag fashion in O(n) time.
 * The converted array should be in form a < b > c < d > e < f.
 */
public class ZigZagArray {

    static void swap(int a[],int i,int j){
        int temp;
        temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    static void zigzag(int a[]){
        boolean flag = true;
        for (int i = 0; i <= a.length-2; i++) {
            if (flag){
                if (a[i]>a[i+1]) { // it will make "<"
                    swap(a,i,i + 1);
                }
            }else{
                if (a[i]<a[i+1]) { // it will make ">"
                    swap(a,i,i + 1);
                }
            }
            flag = !flag;
        }
    }

    static void display(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 7, 8, 6, 2, 1};
        display(arr);
        zigzag(arr);
        display(arr);
    }
}
