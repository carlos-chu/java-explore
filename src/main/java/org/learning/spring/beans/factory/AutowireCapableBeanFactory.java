package org.learning.spring.beans.factory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.learning.spring.BeanReference;
import org.learning.spring.aop.BeanFactoryAware;
import org.learning.spring.beans.BeanDefinition;
import org.learning.spring.beans.PropertyValue;

/**
 * 可自动装配内容的BeanFactory
 * 
 * @author yihua.huang@dianping.com
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + propertyValue.getName().substring(0, 1).toUpperCase()
                                + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }
}
