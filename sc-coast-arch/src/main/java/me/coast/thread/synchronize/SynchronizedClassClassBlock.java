package me.coast.thread.synchronize;

/**
 * @author meiji 类锁2：指定锁为class对象
 */
public class SynchronizedClassClassBlock implements Runnable {
    static SynchronizedClassClassBlock instanec = new SynchronizedClassClassBlock();
    static SynchronizedClassClassBlock instanec2 = new SynchronizedClassClassBlock();

    public static void main(String[] args) {
        Thread th1 = new Thread(instanec);
        Thread th2 = new Thread(instanec2);
        th1.start();
        th2.start();
        while (th1.isAlive() || th2.isAlive()) {

        }
        System.out.println("完成！！！");
    }

    @Override
    public void run() {
        method();

    }

    private void method() {
        synchronized (SynchronizedClassClassBlock.class) {
            System.out.println("我是类锁的第二种形式，synchronize（*.class），我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"结束");
        }

    }
}
