package com.noon;

// array of 10 million entries, entry lies between 0 - 255. Sort the array.
public class Problem {

    static void sort(int arr[]){
        int frequency[] = new int[256];
        for (int i = 0; i < arr.length; i++) {
            frequency[arr[i]]++;
        }

        for (int i = 0; i < frequency.length; i++) {
            while (frequency[i]--!=0){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,5,56,4,75,89, 66, 100, 120, 110, 2};
        sort(arr);
    }
}
