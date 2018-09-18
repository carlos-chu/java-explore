package org.learning.patterns.proxy;

/**
 * 静态代理
 *
 * @Auther: bjchuwenqiang
 * @Date: 2018/9/18
 */
public class StaticProxy {
    /**
     * 代理接口
     */
    public interface BizProcesser {
        void processBiz();
    }

    public static class SomeOneBizProcesser implements BizProcesser {

        @Override
        public void processBiz() {
            System.out.println("某个业务实现了接口，执行了业务，SomeOne do biz");
        }
    }

    public static class BizProcesserProxy implements BizProcesser {

        private BizProcesser target = null;

        /**
         * 传进来目标类的实例，用于在其前后包装下
         *
         * @param target
         */
        public BizProcesserProxy(BizProcesser target) {
            this.target = target;
        }

        @Override
        public void processBiz() {
            System.out.println("在业务之前执行。。。");
            target.processBiz();
            System.out.println("在业务之后执行。。。");
        }
    }

    public static void main(String[] args) {
        SomeOneBizProcesser someOneBizProcesser = new SomeOneBizProcesser();
        BizProcesserProxy proxy = new BizProcesserProxy(someOneBizProcesser);
        proxy.processBiz();
    }
}
