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
            synchronized (rB) {
                return rB.value + rA.value;
            }
        }
    }

    public void write(int a, int b) {
        synchronized (rB) {
            synchronized (rA) {
                rA.value = a;
                rB.value = b;
            }
        }
    }
}
