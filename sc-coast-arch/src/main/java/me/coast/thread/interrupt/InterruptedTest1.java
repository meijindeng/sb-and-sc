package me.coast.thread.interrupt;

public class InterruptedTest1 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable1());
        t.setName("线程t");
        t.start();
        //中断睡眠，唤醒线程
        t.interrupt();
        System.out.println("isInterrupted检测中断，不清除中断状态："+t.isInterrupted());
        System.out.println("interrupted检测中断并清除中断状态1："+t.interrupted());
        System.out.println("thread是否存活："+t.isAlive());
    }
}

class MyRunnable1 implements Runnable{
    //run方法中的异常只能try catch不能throws，因为run方法在父类中没有抛出任何异常，子类不能比父类抛出更多的异常
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-----begin");
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
        }
        System.out.println(Thread.currentThread().getName()+"-----end");
    }
}
