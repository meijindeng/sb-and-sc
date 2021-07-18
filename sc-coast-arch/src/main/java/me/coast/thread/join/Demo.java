package me.coast.thread.join;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    private String currentTime;

    /**
     *获取当前时间
     */
    class TimeThread extends Thread{
        @Override
        public void run() {
            String pattern = "yyyy-MM-dd hh:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            currentTime = sdf.format(new Date());
            System.out.println("获取时间："+currentTime);
        }
    }

    /**
     * 显示时间
     */
    class ShowThread extends Thread{
        @Override
        public void run() {
            System.out.println("显示时间:"+currentTime);
        }
    }


    public static void main(String[] args) {
        Demo clock = new Demo();
        TimeThread timeThread = clock.new TimeThread();
        ShowThread showThread = clock.new ShowThread();
        timeThread.start();
        showThread.start();
    }
}
