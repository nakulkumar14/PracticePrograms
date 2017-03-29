package com.practice;

/**
 * Created by nakul on 29-Mar-17.
 */
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

class Student{
    final int x;
    final String name;
    final Project p;

    public Student(int x, String name, Project p) {
        this.x = x;
        this.name = name;
        this.p = p;
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
}

public class ImmutableExample {
    public static void main(String[] args) {
        Project p = new Project("Project X");

        Student student = new Student(10,"nakul", p);
        Project p1 = student.getP();
        System.out.println(p1.getName());
        p1.setName("test");
        System.out.println(p1.getName());
        System.out.println(student.getP().getName());
    }
}
