package org.learning.grammar.exception;

/**
 * @ClassName: TryCatch
 * @Description: 演示try catch finally语法
 * @author carlos.chu
 * @date 2016年3月17日 下午4:11:11
 */
public class TryCatch {

    public static void main(String[] args) {
        System.out.println(orderDemo());
    }

    // 测试执行的顺序
    private static String orderDemo() {
        try {
            System.out.println("try里执行代码");
            // throw new RuntimeException();
            return "try 里返回";
        } catch (Exception e) {
            System.out.println("catch 里执行代码");
            return "catch 里返回";
        } finally {
            System.out.println("finally 里执行代码");
            // return "finally 里返回";
        }
    }
}
