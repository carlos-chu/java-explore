package org.learning.concurrent.thread;

/**
 * @ClassName: JoinThread
 * @Description: 演示join机制
 * @author carlos.chu
 * @date 2016年3月17日 下午2:43:05
 *
 */
public class JoinThread {

    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);
        Joiner depey = new Joiner("Depey", sleepy); // sleeper执行完后执行depey
        Joiner doc = new Joiner("Doc", grumpy);
        grumpy.interrupt(); // grumpy被打断后被加入的线程能马上执行
    }
}

class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (Exception e) {
            return;
        }
        System.out.println(getName() + " 醒了");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " 加入完成");
    }
}
