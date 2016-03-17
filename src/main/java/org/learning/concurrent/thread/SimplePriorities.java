package org.learning.concurrent.thread;

/**
 * @ClassName: SimplePriorities
 * @Description: 简单的优先级线程
 * @author carlos.chu
 * @date 2016年3月17日 上午11:31:40
 *
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 1; i < 10000; i++) {
                
            }
        }
    }

}
