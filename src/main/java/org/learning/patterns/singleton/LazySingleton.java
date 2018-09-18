package org.learning.patterns.singleton;

/**
 * 懒汉单例模式
 *
 * @Auther: bjchuwenqiang
 * @Date: 2018/9/18
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    /**
     * 线程不安全获取
     *
     * @return
     */
    public static LazySingleton getUnsafeInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 获取线程安全的单例
     *
     * @return
     */
    public static synchronized LazySingleton getSafeInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
