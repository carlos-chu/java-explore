package org.learning.spring.aop;

import org.learning.spring.beans.factory.BeanFactory;

/**
 * @author yihua.huang@dianping.com
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
