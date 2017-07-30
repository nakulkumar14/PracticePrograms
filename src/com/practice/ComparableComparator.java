package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by nakul on 30/7/17.
 */

class Employee implements Comparable<Employee>{

    private int age;
    private String name;

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class NameSorter implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class ComparableComparator {

    public static void main(String[] args) {
        Employee e1 = new Employee(10,"tom");
        Employee e2 = new Employee(12,"lisa");
        Employee e3 = new Employee(8,"wally");

        List list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        System.out.println("original : ");
        System.out.println(list);

        Collections.sort(list);

        System.out.println("comparable : ");
        System.out.println(list);

        System.out.println("name sorted - comparator : ");
        Collections.sort(list,new NameSorter());
        System.out.println(list);
    }

}

