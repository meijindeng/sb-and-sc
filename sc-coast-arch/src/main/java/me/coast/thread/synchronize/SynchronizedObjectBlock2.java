package me.coast.thread.synchronize;

/**
 * @author meiji 对象锁实例2，同步代码块锁（自己指定锁对象）
 */
public class SynchronizedObjectBlock2 implements Runnable {
    static SynchronizedObjectBlock1 instance = new SynchronizedObjectBlock1();

    public static void main(String[] args){
        Thread th1 = new Thread(instance);
        Thread th2 = new Thread(instance);
        th1.start();
        th2.start();
        while (th1.isAlive() || th2.isAlive()) {
        }
        System.out.println("完成！！！");
    }


    Object lock1=new Object();
    Object lock2=new Object();
    @Override
    public void run() {
        synchronized (lock1) {

            // Thread.currentThread（）当前线程，.getName（）名字
            System.out.println("我是对象锁的代码块形式我叫" + Thread.currentThread().getName());
            try {
                // 让线程休眠3秒
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
        synchronized (lock2) {

            // Thread.currentThread（）当前线程，.getName（）名字
            System.out.println("我是对象锁的代码块形式我叫" + Thread.currentThread().getName());
            try {
                // 让线程休眠3秒
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "运行结束");
        }

    }
}
