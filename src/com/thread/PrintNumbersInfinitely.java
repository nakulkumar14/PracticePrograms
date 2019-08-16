package com.thread;

class SharedClass{
    Object lock = new Object();
}

class Mythread1 extends Thread{

    private SharedClass sharedClass;

    public Mythread1(SharedClass sharedClass) {
        this.sharedClass = sharedClass;
    }

    @Override
    public void run() {

        synchronized (sharedClass.lock){
            int i = 1;
            while(true && i < 10){
                System.out.println(i);
                i+=2;
                sharedClass.lock.notify();
                try {
                    sharedClass.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Mythread2 extends Thread{

    private SharedClass sharedClass;

    public Mythread2(SharedClass sharedClass) {
        this.sharedClass = sharedClass;
    }

    @Override
    public void run() {

        synchronized (sharedClass.lock){
            int i = 2;
            while(true && i < 10){
                System.out.println(i);
                i+=2;
                sharedClass.lock.notify();
                try {
                    sharedClass.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


public class PrintNumbersInfinitely {
    public static void main(String[] args) {
        SharedClass sharedClass = new SharedClass();
        Mythread1 m1 = new Mythread1(sharedClass);
        Mythread2 m2 = new Mythread2(sharedClass);
        m1.start();
        m2.start();
    }
}
