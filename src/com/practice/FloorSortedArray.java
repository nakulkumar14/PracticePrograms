package com.practice;

/**
 * Created by nakul on 17-Dec-16.
 */
public class FloorSortedArray {

    private static int floor(int[] a, int x, int l, int h) {
        if (l>h)return -1;
        int mid = (l+h)/2;
        if (a[mid]==x)
            return x;
        if (a[mid] < x){
            if (mid+1 < h && a[mid+1] > x)
                return a[mid];
            if (mid+1 > h)
                return a[mid];
        }

        if (a[mid] < x){
            int f = floor(a,x,mid+1,h);
            return f!=-1?f:a[mid];
        }
        return floor(a,x,l,mid-1);
    }

    public static void main(String[] args) {
        int a[]={2,4,5,7,9,10};
        System.out.println("Floor : "+floor(a,5,0,a.length-1));
        System.out.println("Floor : "+floor(a,6,0,a.length-1));
        System.out.println("Floor : "+floor(a,11,0,a.length-1));
        System.out.println("Floor : "+floor(a,1,0,a.length-1));
        System.out.println("Floor : "+floor(a,3,0,a.length-1));
        System.out.println("Floor : "+floor(a,2,0,a.length-1));
        System.out.println("Floor : "+floor(a,4,0,a.length-1));
    }
}
