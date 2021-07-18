package me.coast.thread.a1b2c3;

/**
 * wait/notify + synchronized实现
 */

import java.util.concurrent.TimeUnit;

public class WaitNotifyTest1 {
    public static void main(String[] args) {

        Object obj = new Object();

        new Thread(() -> {
            synchronized (obj) {
                for (char i = 'A'; i <= 'Z'; i++) {
                    System.out.println(Thread.currentThread().getName() + "======== " + i);
                    obj.notify();
                    try {
                        obj.wait();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "thread-A").start();

        new Thread(() -> {
            synchronized (obj) {
                for (int i = 1; i <= 26; i++) {
                    System.out.println(Thread.currentThread().getName() + "======== " + i);
                    obj.notify();
                    try {
                        obj.wait();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "thread-1").start();
    }
}
