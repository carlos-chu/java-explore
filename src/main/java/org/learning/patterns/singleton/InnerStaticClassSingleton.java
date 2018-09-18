package org.learning.patterns.singleton;

/**
 * 内部静态类单例
 *
 * @Auther: bjchuwenqiang
 * @Date: 2018/9/18
 */
public class InnerStaticClassSingleton {

    private static class Holder {
        private static InnerStaticClassSingleton INSTANCE = new InnerStaticClassSingleton();
    }

    private InnerStaticClassSingleton() {
    }

    public static InnerStaticClassSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
