package org.learning.algorithm.algorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @ClassName: StringContains
 * @Description: 字符串包含
 * @author carlos.chu
 * @date 2016年5月18日 下午2:41:00
 */
public class StringContains {

    /**
     * 先排序，在二分查找
     * 
     * @param a
     * @param b
     */
    public static boolean containsOne(String[] a, String[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        for (String temp : b) {
            int search = Arrays.binarySearch(a, temp);
            if (search < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsTwo(String[] a, String[] b) {
        Collection<String> set = new HashSet<String>();
        for (String t : a) {
            set.add(t);
        }
        for (String t : b) {
            if (!set.contains(t)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] a = "D A C E".split(" ");
        String[] b = "A E".split(" ");
        String[] c = "A e".split(" ");

        System.out.println(containsOne(a, b));

        System.out.println(containsTwo(a, b));
    }
}
