package org.learning.concurrent.thread;

/**
 * @ClassName: DeadlockRisk
 * @Description: 死锁
 * @author carlos.chu
 * @date 2016年4月5日 上午11:28:52
 *
 */
public class DeadlockRisk {

    private static class Resource {
        public int value;
    }

    private Resource rA = new Resource();
    private Resource rB = new Resource();

    public int read() {
        synchronized (rA) {
            System.out.println("read():" + Thread.currentThread().getName() + "获取了resourceA 的锁！");
            synchronized (rB) {
                System.out.println("read():" + Thread.currentThread().getName() + "获取了resourceB 的锁！");
                return rB.value + rA.value;
            }
        }
    }

    public void write(int a, int b) {
        synchronized (rB) {
            System.out.println("write():" + Thread.currentThread().getName() + "获取了resourceB 的锁！");
            synchronized (rA) {
                System.out.println("write():" + Thread.currentThread().getName() + "获取了resourceA 的锁！");
                rA.value = a;
                rB.value = b;
            }
        }
    }

    public static void main(String[] args) {
        final DeadlockRisk d = new DeadlockRisk();
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    d.write(1, 2);
                    System.out.println(d.read());
                }
            });
            t.setName("线程" + i);
            t.start();
        }
    }
}
