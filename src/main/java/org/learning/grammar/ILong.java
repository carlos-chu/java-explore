package org.learning.grammar;

/**
 * @ClassName: ILong
 * @Description: long类型注意点
 * @author carlos.chu
 * @date 2016年6月8日 下午2:37:40
 *
 */
public class ILong {

    /**
     * 大写的声明方式是会进行Long.valueOf(long l)的方法的，这样会在-128-127之间有个选择，这是
     * LongCache实现的一部分，对于超过的部分会直接new出来新的Long对象。
     * 小写的声明不会进行valueOf过程，不会自动装箱
     */
    Long a = 5L;

}
