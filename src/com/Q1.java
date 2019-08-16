package com;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

        List myList = new ArrayList();
        myList.add(new Integer(1));
        myList.add(new Double(2));

        Integer x = (Integer) myList.get(0);
        Double y = (Double) myList.get(1);

        System.out.println(x);
        System.out.println(y);
    }
}
