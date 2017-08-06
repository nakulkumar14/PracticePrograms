package com.thread;

/**
 * Created by nakul on 6/8/17.
 *
 * Using two threads print numbers alternatively till 10.
 */
public class PrintNumbersInSequence {

    static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 1 ;i<11;i+=2){
                        System.out.println(i);
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 2 ;i<11;i+=2){
                        System.out.println(i);
                        try {
                            lock.notify();
                            if (i==10)
                                break;
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
