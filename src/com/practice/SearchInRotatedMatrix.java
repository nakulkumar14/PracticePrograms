package com.practice;

/**
 * Created by nakul on 02-Apr-17.
 */
public class SearchInRotatedMatrix {

    static void display(int a[][]){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void search(int a[][],int key){
        int i = a.length-1;
        int j = 0;
        while (i>=0 && j<a[0].length){
            if (a[i][j]<key)
                j++;
            else if (a[i][j]>key)
                i--;
            else
            {
                System.out.println(a[i][j]+" found!");
                return;
            }
        }
        System.out.println("Not found");
    }

    public static void main(String[] args) {
        int a[][]={
                {5,10,15,20},
                {17,19,21,23},
                {20,23,26,29}
        };
        display(a);
        search(a,15);
        search(a,22);
        search(a,19);
        search(a,30);
    }
}
