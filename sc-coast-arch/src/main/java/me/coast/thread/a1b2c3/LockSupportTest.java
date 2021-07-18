package me.coast.thread.a1b2c3;

/**
 * LockSupport实现
 */

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    private static Object o = new Object ();
    private static Thread t1, t2;
    private static volatile boolean flag = false;
    public static void main(String[] args) {
        char[] chars1 = "ABCDEF".toCharArray ();
        char[] chars2 = "123456".toCharArray ();
        t1 = new Thread (() -> {
            while(flag){}
            for (int i = 0; i < chars1.length; i++) {
                LockSupport.unpark (t2);
                System.out.print (chars1[i]);
                flag = true;
                LockSupport.park ();
            }
        });
        t2 = new Thread (() -> {
            while(!flag){}
            for (int i = 0; i < chars2.length; i++) {
                LockSupport.park ();
                System.out.println (chars2[i]);
                LockSupport.unpark (t1);
            }
        });
        t1.start ();
        t2.start ();
    }
}
