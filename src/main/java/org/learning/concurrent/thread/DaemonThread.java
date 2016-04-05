package org.learning.concurrent.thread;

/**
 * @ClassName: DaemonThread
 * @Description: 守护线程
 * @author carlos.chu
 * @date 2016年4月1日 下午5:00:22
 *
 */
public class DaemonThread {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(11111111);
            }
        });
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
