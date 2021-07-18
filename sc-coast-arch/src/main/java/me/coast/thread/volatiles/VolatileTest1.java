package me.coast.thread.volatiles;

public class VolatileTest1 extends Thread {
    private static volatile boolean flag = false;

    public void run() {
        while (!flag) {
            System.out.println("当前时间="+System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws Exception {
        new VolatileTest1().start();
        Thread.sleep(2000);
        flag = true;
    }
}
