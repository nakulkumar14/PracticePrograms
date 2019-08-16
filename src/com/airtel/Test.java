package com.airtel;

import java.util.Arrays;
import java.util.List;

class Parent{
    private void show(){
        System.out.println("parent");
    }
}

class Child extends Parent{
    private void show(){
        System.out.println("child");
    }
}


public class Test {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("this is line", "this is bigger line", "small line");
//        String s = list.stream().sorted((x,y)->y.length() - x.length()).findFirst().get();
//        System.out.println(s);
        Parent p = new Child();
        System.out.println(1.2/0);
    }
}
