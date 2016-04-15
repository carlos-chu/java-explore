package org.learning.grammar.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: FailFirst
 * @Description: 快速报错
 * @author carlos.chu
 * @date 2016年4月11日 下午5:08:42
 *
 */
public class FailFirst {

    public static void main(String[] args) {
        List list = new ArrayList();
        Iterator iterator = list.iterator();
        list.add(1);
        iterator.next();
    }
    
}
