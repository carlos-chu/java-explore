package org.learning.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * @author yihua.huang@dianping.com
 */
public interface Advisor {

    Advice getAdvice();
}
