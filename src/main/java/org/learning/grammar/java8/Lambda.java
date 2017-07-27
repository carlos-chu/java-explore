package org.learning.grammar.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Lambda表达式和函数式接口
 * 
 * @author bjchuwenqiang
 * @date 2017年7月27日
 */
public class Lambda {

	public static void main(String[] args) {
		Lambda la = new Lambda();
		la.lambda1();
		System.out.println("=========lambda2===========");
		la.lambda2();
	}

	public void lambda1() {
		Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

		// 非lambda方式
		List<String> list = Arrays.asList("a", "b", "c");
		for (String e : list) {
			System.out.println(e);
		}
	}

	public void lambda2() {
		Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e));

		Arrays.asList("a", "b", "c").sort((e1, e2) -> e1.compareTo(e2));
	}

	public void lambda3() {

	}
}
