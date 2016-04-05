package org.learning.concurrent.thread;

/**
 * @ClassName: EfficientReadWriteLock
 * @Description: 高效Volatile
 * @author carlos.chu
 * @date 2016年4月5日 下午2:18:21
 *
 */
public class EfficientVolatile {

    private volatile int value;

    public int getValue() {
        return value;
    }

    public synchronized int increment() {
        return value++;
    }
}
