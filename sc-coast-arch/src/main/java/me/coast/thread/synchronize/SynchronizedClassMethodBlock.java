package me.coast.thread.synchronize;

/**
 * @author meiji 类锁1：synchronize修饰静态的方法，synchronize加在static方法上。
 */
public class SynchronizedClassMethodBlock implements Runnable {
    static SynchronizedClassMethodBlock instance1 = new SynchronizedClassMethodBlock();
    static SynchronizedClassMethodBlock instance2 = new SynchronizedClassMethodBlock();

    public static void main(String[] args) {
        Thread th1 = new Thread(instance1);
        Thread th2 = new Thread(instance2);
        th1.start();
        th2.start();
        while (th1.isAlive() || th2.isAlive()) {
        }
        System.out.println("完成！！！");
    }

    public void run() {
        method();
    }

    public static synchronized void method(){
        System.out.println("我是类锁的第一种形式，static形式，我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束");
    }

}
