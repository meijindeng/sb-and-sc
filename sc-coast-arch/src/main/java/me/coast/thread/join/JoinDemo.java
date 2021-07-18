package me.coast.thread.join;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JoinDemo {

    String currentTime;

    class ShowThread extends Thread{

        TimeThread timeThread ;
        public ShowThread(TimeThread timeThread) {
            this.timeThread = timeThread;
        }
        @Override
        public void run() {
            try {
                timeThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("显示时间："+currentTime);
        }
    }

    class TimeThread extends Thread{

        @Override
        public void run() {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            currentTime = sdf.format(new Date());
            System.out.println("获取时间："+currentTime);
        }
    }

    public static void main(String[] args) {
        JoinDemo clock = new JoinDemo();
        TimeThread timethread = clock.new TimeThread();
        ShowThread showThread = clock.new ShowThread(timethread);
        timethread.start();
        showThread.start();
    }

}
