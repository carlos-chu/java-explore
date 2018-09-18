package org.learning.patterns.singleton;

/**
 * 双重锁检查
 *
 * @Auther: bjchuwenqiang
 * @Date: 2018/9/18
 */
public class DoubleCheckSafeSingleton {
    /**
     * 加上volatile关键字，防止内存重排序，因为它在JVM层面上规定了禁止指令重排序，在执行指令前后加上了内存屏障
     */
    private volatile static DoubleCheckSafeSingleton instance = null;

    private DoubleCheckSafeSingleton() {
    }

    public static DoubleCheckSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSafeSingleton.class) {
                if (instance == null) {
                    /**
                     * 这一步JVM做了三件事
                     * 1.给instance在堆上分配内存
                     * 2.调用DoubleCheckSafeSingleton的构造函数完成初始化
                     * 3.把instance在栈上的引用指向堆上的地址，这时instance就不是null了
                     * JVM会进行优化，是执行重排序，导致有可能不是按1.2.3的顺序执行的，有可能3在2之前执行了，导致多线程情况下判断出错
                     */
                    instance = new DoubleCheckSafeSingleton();
                }
            }
        }
        return instance;
    }
}
