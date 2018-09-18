package org.learning.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理模式
 *
 * @Auther: bjchuwenqiang
 * @Date: 2018/9/18
 */
public class DynamicProxy {
    public interface BizProcesser {
        void processBiz();
    }

    public static class SomeOneBizProcesser implements BizProcesser {

        @Override
        public void processBiz() {
            System.out.println("某个业务实现了接口 some on do biz");
        }
    }

    public static void main(String[] args) {
        BizProcesser target = new SomeOneBizProcesser();
        BizProcesser instance = (BizProcesser) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行目标方法执行之前。。。");
                Object result = method.invoke(target, args);
                System.out.println("执行目标方法执行之后。。。");
                return result;
            }
        });
        instance.processBiz();
    }
}
