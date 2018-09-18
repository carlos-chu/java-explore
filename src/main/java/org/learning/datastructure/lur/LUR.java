package org.learning.datastructure.lur;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用算法
 *
 * @author cwq
 * @date
 */
public class LUR<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {

    /**
     * 默认的容量
     */
    public static Integer DEFAULT_SIZE = 8;

    public LUR(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    /**
     * 重写LinkedHashMap#removeEldestEntry()方法，当元素中的数多于N个时，删除最近不使用的元素
     *
     * @param eldest
     * @return
     * @see LinkedHashMap#removeEldestEntry
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        if (super.size() > DEFAULT_SIZE) {
            return true;
        }
        return false;
    }
}
