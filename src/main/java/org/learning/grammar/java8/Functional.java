package org.learning.grammar.java8;

/**
 * 函数式接口
 * 
 * @author bjchuwenqiang
 * @date 2017年7月27日
 */
public class Functional {

	@FunctionalInterface
	public interface FunctionalInter {

		public void sayHello(String msg);

		public default void defaultMethod() {
			System.out.println("default method");
		}

		public static void staticMethod() {
			System.out.println("static method");
		}
	}

	public static void main(String[] args) {
		FunctionalInter func = msg -> System.out.println("hello");
		func.sayHello("hello");
		FunctionalInter.staticMethod();
		
		Functional.Clazz clazz = new Functional().new Clazz();
		clazz.defaultMethod();
	}

	class Clazz implements FunctionalInter {

		@Override
		public void sayHello(String msg) {
			
		}
	}
}
