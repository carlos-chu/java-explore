package org.learning.concurrent.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: ReadWriteLock
 * @Description: 读写锁
 * @author carlos.chu
 * @date 2016年4月5日 下午2:51:38
 *
 */
public class ReadWriteLock {

    private static int count;

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        try {
            lock.writeLock().lock();
            write();
            lock.readLock().lock();
            read();
        } finally {
            lock.readLock().unlock();
            lock.writeLock().unlock();
        }
    }

    private static int read() {
        return count;
    }

    private static void write() {
        count++;
    }
}
