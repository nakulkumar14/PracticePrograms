package com.practice;

/**
 * Created by nakul on 16-Apr-17.
 * Find an element in rotated and sorted array.
 */
public class SearchInSortedRotatedArray {

    static int search(int a[],int l,int h,int key){
        if (l==h){
            return a[l]==key?l:-1;
        }
        if (l>h)
            return -1;

        int mid = (l+h)/2;
        if (a[mid]==key)
            return mid;

        if (a[l] <=a[mid]){
            if (a[l]<=key && key<=a[mid])
                return search(a,l, mid-1,key);
            return search(a,mid+1, h,key);
        }else{
            if (a[mid]<=key && key<=a[h])
                return search(a,mid+1, h,key);
            return search(a,l,mid-1,key);
        }
    }

    static void display(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[]={5, 6, 7, 8, 9, 10, 1, 2, 3};
        display(a);
        System.out.println("Found at : "+search(a,0,a.length-1,3));
        System.out.println("Found at : "+search(a,0,a.length-1,30));

        int arr[] = {30, 40, 50, 10, 20};
        System.out.println("Found at : "+search(arr,0,arr.length-1,10));
        System.out.println("Found at : "+search(arr,0,arr.length-1,30));
    }
}
