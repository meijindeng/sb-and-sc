package me.coast.thread.synchronize;

/**
 * @author meiji 对象锁，方法锁（默认锁对象为this当前实例对象）
 */
public class SynchronizedObjectMethodBlock1 implements Runnable {
    static SynchronizedObjectMethodBlock1 intance=new SynchronizedObjectMethodBlock1();
    public static void main(String[] args) {
        Thread th1=new Thread(intance);
        Thread th2=new Thread(intance);
        th1.start();
        th2.start();
        while(th1.isAlive() || th2.isAlive()){
        }
        System.out.println("完成！！！");
    }
    public void run() {
        method();
    }
    public synchronized void method(){
        System.out.println("我是对象锁的方法修饰符形式（方法锁），我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}
