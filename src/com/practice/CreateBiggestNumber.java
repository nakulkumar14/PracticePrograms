package com.practice;

import java.util.*;

/**
 * Created by nakul on 17/9/17.
 * Given an array of numbers, arrange them in a way that yields the largest value.
 * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.
 * And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
 */

class ExtendNum{
    String old;
    String newNum;

    public ExtendNum(String old, String newNum) {
        this.old = old;
        this.newNum = newNum;
    }
}

public class CreateBiggestNumber {

    // Consider numbers to be in string format.
    // For every number, x and y compare x+y with y+x and sort them.
    static void printLargest(String arr[]){
        List<String> strings = Arrays.asList(arr);
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String x = o1+o2;
                String y = o2+o1;
                return x.compareTo(y)>0?-1:1;
            }
        });
        System.out.println(strings);
    }

    static void printLargest2(String arr[]){
        // find the maximum digits in a number from the array which will be from largest number.
        int digits = countDigits(arr);

        // create a user defined object to store old number and new number.
        List<ExtendNum> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            StringBuilder str = new StringBuilder();
            // concatenate the number to itself and set length to digits+1.
            // truncate remaining digits.
            extendNums(str,arr[i],digits);
            //add object to list.
            list.add(new ExtendNum(arr[i],str.toString()));
        }

        // sort the list based on new numbers.
        Collections.sort(list, new Comparator<ExtendNum>() {
            @Override
            public int compare(ExtendNum o1, ExtendNum o2) {
                return o2.newNum.compareTo(o1.newNum);
            }
        });

        Iterator<ExtendNum> i = list.iterator();
        while (i.hasNext()){
            System.out.print(i.next().old);
        }

    }

    static void extendNums(StringBuilder str,String old,int digits){
        while(str.length() <= digits+1){
            str.append(old);
        }

        str.setLength(digits+1);
    }

    static int countDigits(String arr[]){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > count)
                count = arr[i].length();
        }
        return count;
    }

    public static void main(String[] args) {
        String arr[] = {"54","546","548","60"};
        printLargest(arr);
        printLargest2(arr);
    }
}
