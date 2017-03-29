package com.thread;

/**
 * Created by nakul on 29-Mar-17.
 */
class MyThread{
    String o1 = "one";
    String o2 = "two";

    void show(){
        synchronized (o1){
            System.out.println(Thread.currentThread().getName()+" taken lock on "+o1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName()+" : Waiting for lock on "+o2);
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+" taken lock on "+o2);
            }

            System.out.println(Thread.currentThread().getName()+" finished.");
        }
    }

    void display(){
        synchronized (o2){
            System.out.println(Thread.currentThread().getName()+" taken lock on "+o2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName()+" : Waiting for lock on "+o1);
            synchronized (o1){
                System.out.println(Thread.currentThread().getName()+" taken lock on "+o1);
            }

            System.out.println(Thread.currentThread().getName()+" finished.");
        }
    }

}

class TestThread extends Thread{

    MyThread myThread = new MyThread();

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("firstthread"))
            myThread.show();
        else
            myThread.display();
    }
}

public class DeadLock {
    public static void main(String[] args) {
        TestThread t1 = new TestThread();
        TestThread t2 = new TestThread();
        t1.setName("firstthread");
        t2.setName("secondthread");

        t1.start();
        t2.start();
    }
}
