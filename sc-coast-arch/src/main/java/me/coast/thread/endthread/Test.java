package me.coast.thread.endthread;

/**
 *使用Boolean标记，终止线程，使用stop方法强制终止易丢失数据，并且已过时，不推荐使用
 */
public class Test {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.setName("线程t");
        t.start();
        //模拟5秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //终止线程
        r.run = false;
    }
}

class MyRunnable implements Runnable{
    //打一个布尔标记
    boolean run = true;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (run){//进行判断
                System.out.println(Thread.currentThread().getName()+"---->"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                //在此可以进行终止线程之前的操作，比如保存数据
                //终止线程 return，return就结束了
                return;
            }
        }
    }
}
