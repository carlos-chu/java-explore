package org.learning.patterns.singleton;

/**
 * 饿汉模式的单例
 *
 * @Auther: bjchuwenqiang
 * @Date: 2018/9/18
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
