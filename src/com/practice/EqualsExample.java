package com.practice;

/**
 * Created by nakul on 23/7/17.
 */
class Fruit{

}
class Apple extends Fruit{

}
class Mango extends Fruit{

}

public class EqualsExample {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Mango mango = new Mango();

        if (apple instanceof Fruit)
            System.out.println("apple is fruit");
        else
            System.out.println("apple is not fruit");

        if (mango.getClass().getSimpleName().equals(Fruit.class.getSimpleName()))
            System.out.println("mango is not fruit");
        else
            System.out.println("mango is king of fruits");

        System.out.println(mango.getClass().getName());
        System.out.println(mango.getClass().getCanonicalName());
        System.out.println(mango.getClass().getSimpleName());
        System.out.println(mango.getClass().getTypeName());

        System.out.println(Fruit.class.getSimpleName());
    }
}
