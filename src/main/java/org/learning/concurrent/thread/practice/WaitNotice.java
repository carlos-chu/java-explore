package org.learning.concurrent.thread.practice;

public class WaitNotice {

    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();
        // 线程A拥有b对象上的锁。线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者
        synchronized (b) {
            try {
                System.out.println("等待对象b完成计算。。。");
                // 当前线程A等待
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b对象计算的总和是：" + b.total);
        }
    }
}

class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 101; i++) {
                total += i;
            }
            // 完成计算，唤醒在此对象监视器上等待的单个线程，本例中主线程被唤醒
            notify();
        }
    }
}
