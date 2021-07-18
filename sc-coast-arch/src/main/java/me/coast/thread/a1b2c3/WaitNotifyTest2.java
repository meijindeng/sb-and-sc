package me.coast.thread.a1b2c3;

public class WaitNotifyTest2 {
    private static Object obj = new Object ();
    volatile private static boolean flag = false;
    public static void main(String[] args) {
        char[] chars1 = "ABCDEF".toCharArray ();
        char[] chars2 = "123456".toCharArray ();
        new Thread (() -> {
            for (int i = 0; i < chars1.length;) {
                while (flag){};
                System.out.println (chars1[i]);
                //唤醒等待线程,只有两个线程,所以这里唤醒的事另一个线程
                flag = true;

            }
        }).start ();
        new Thread (() -> {

            for (int i = 0; i < chars2.length;) {
                while (!flag){};
                System.out.println (chars2[i]);
                //唤醒等待线程,只有两个线程,所以这里唤醒的事另一个线程
                flag= false;
            }
        }).start ();
    }
}
