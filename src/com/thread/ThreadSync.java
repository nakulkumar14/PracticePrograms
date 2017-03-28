package com.thread;

/**
 * Created by nakul on 28-Mar-17.
 */
class Shared{
    int x;
    int y;
    void add(int a, int b){
        x = a;
        y = b;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+", "+(x+y));
    }
}

class Thread1 implements Runnable{
    Shared shared;

    public Thread1(Shared shared, String name) {
        Thread.currentThread().setName(name);
        this.shared = shared;
    }

    @Override
    public void run() {
        shared.add(10,20);
    }
}

class Thread2 implements Runnable{

    Shared shared;

    public Thread2(Shared shared, String name) {
        Thread.currentThread().setName(name);
        this.shared = shared;
    }

    @Override
    public void run() {
        shared.add(5,6);
    }
}


public class ThreadSync {

    public static void main(String[] args) {
        Shared s = new Shared();
        Thread1 first = new Thread1(s, "first");
        new Thread(first).start();
        Thread2 second = new Thread2(s, "second");
        new Thread(second).start();
    }
}
