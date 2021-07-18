package me.coast.thread.interrupt;

/**
 * 当线程sleep之后，可以通过interrupt方法唤醒线程（这个方式依靠的是Java异常机制）
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.setName("线程t");
        t.start();
        //希望5秒之后唤醒线程
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断睡眠，唤醒线程
        t.interrupt();
        System.out.println("检测中断，不清除中断状态："+t.isInterrupted());
        System.out.println("检测中断并清除中断状态："+t.interrupted());
    }
}

class MyRunnable implements Runnable{
    //run方法中的异常只能try catch不能throws，因为run方法在父类中没有抛出任何异常，子类不能比父类抛出更多的异常
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-----begin");
        try {
            Thread.sleep(1000*60*60*24*365);//睡眠一年   //5秒之后会让这里出现异常进入catch执行
        } catch (InterruptedException e) {
            //打印异常信息（注释就不打印，走下一步，结束线程）
            //e.printStackTrace();//出现异常，会报java.lang.InterruptedException: sleep interrupted（睡眠被中断)
        }
        //一年后才能执行
        System.out.println(Thread.currentThread().getName()+"-----end");
    }
}