package me.coast.thread.volatiles;

/**
 * 模拟volatile关键字
 */
public class VolatileTest extends Thread {
    private static volatile boolean flag = false;

    public void run() {
        while (!flag);
    }

    public static void main(String[] args) throws Exception {
        new VolatileTest().start();
        Thread.sleep(2000);
        System.out.println("finish");
        flag = true;
    }
}
