package com.practice;

/**
 * Created by nakul on 02-Apr-17.
 */
public class RightRotateMatrix {

    static void display(int a[][]){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void rightRotate(int a[][]){
        int r,c;
        if (a.length!=a[0].length)
        {
            r=a[0].length;
            c=a.length;
        }else{
            r=c=a.length;
        }

        int temp[][]=new int[r][c];

        int p=0;
        int q=c-1;
        for (int i=0;i<a.length;i++){
            for (int j = 0; j < a[0].length; j++) {
                temp[p][q]=a[i][j];
                p++;
            }
            p=0;
            q--;
        }

        display(temp);
    }

    public static void main(String[] args) {
        int a[][]={
                {5,10,15},
                {7,14,21},
                {8,16,24}
        };
        display(a);
        rightRotate(a);

    }
}
