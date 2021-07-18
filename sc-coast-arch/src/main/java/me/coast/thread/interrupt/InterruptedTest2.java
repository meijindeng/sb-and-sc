package me.coast.thread.interrupt;

public class InterruptedTest2 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable2());
        t.start();
        t.interrupt();
        //sleep等待1秒，等myThread运行完
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("myThread线程是否存活："+t.isAlive());
    }
}

class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i="+ i);
            if(Thread.currentThread().isInterrupted()){
                System.out.println("通过this.isInterrupted()检测到中断");
                System.out.println("第一个interrupted()检测中断："+Thread.currentThread().interrupted());
                System.out.println("第二个interrupted()清除中断："+Thread.currentThread().interrupted());
                break;
            }
        }
        System.out.println("因为检测到中断，所以跳出循环，线程到这里结束，因为后面没有内容了");
    }
}

