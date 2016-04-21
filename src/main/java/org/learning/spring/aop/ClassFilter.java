package org.learning.spring.aop;

/**
 * @author yihua.huang@dianping.com
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}
