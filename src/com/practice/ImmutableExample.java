package com.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nakul on 29-Mar-17.
 */

// This class be member of immutable class.
class Project{
    String name;

    public Project(Project p) {
        name = p.getName();
    }

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


// Class which will be immutable
class Student{
    private final int x;
    private final String name;
    private final Project p;
    private final HashMap<String,String> map;

    public Student(int x, String name, Project p, HashMap map) {
        this.x = x;
        this.name = name;
        this.p = p;
        this.map = map;
    }

    public int getX() {
        return x;
    }

    public String getName() {
        return name;
    }

    public Project getP() {
//        return p;
        return new Project(p);
    }

    public HashMap<String, String> getMap() {
//        return map;
        return (HashMap<String, String>) map.clone();
    }
}

public class ImmutableExample {
    public static void main(String[] args) {
        Project p = new Project("Project X");

        HashMap<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");

        Student student = new Student(10,"nakul", p, map);
        Project p1 = student.getP();
        System.out.println(p1.getName());
        p1.setName("test");
        System.out.println(p1.getName());
        System.out.println(student.getP().getName());

        Map x = student.getMap();
        System.out.println("map : "+x.get("1"));
        x.put("1","xxx");

        System.out.println("local map : "+x.get("1"));
        System.out.println("map : "+student.getMap().get("1"));
    }
}
