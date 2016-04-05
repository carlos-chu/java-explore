package org.learning.concurrent.thread;

/**
 * @ClassName: NoVisibility
 * @Description: 多线程程序下不可见性导致的混乱
 * @author carlos.chu
 * @date 2016年4月1日 下午4:23:14
 *
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
