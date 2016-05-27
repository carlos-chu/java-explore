package org.learning.algorithm.algorithm;

import java.util.Arrays;

/**
 * @ClassName: MoveString
 * @Description: 移动字符串算法，把abcdef的前两个字符移到后边
 * @author carlos.chu
 * @date 2016年5月18日 上午10:59:20
 */
public class MoveString {

    // 1.暴力移位法
    public static void leftShiftOne(String[] s) {
        int m = 2; // 移动几个字符
        while (m-- > 0) {
            String temp = s[0]; // 保存第一个字符

            for (int i = 1; i < s.length; i++) {
                s[i - 1] = s[i];
            }
            s[s.length - 1] = temp;
        }
    }

    // 2.三步反转法
    public static void leftShiftTwo(String[] s) {
        int m = 3; // 移动几个字符
        int n = s.length;
        reverseString(s, 0, m - 1);
        reverseString(s, m, n - 1);
        reverseString(s, 0, n - 1);
    }

    private static void reverseString(String[] s, int from, int to) {
        while (from < to) {
            String temp = s[from];
            s[from++] = s[to];
            s[to--] = temp;
        }
    }

    public static void main(String[] args) {
        String[] s = new String("a b c d e f").split(" ");
        leftShiftOne(s);
        System.out.println(Arrays.asList(s));

        String[] s1 = new String("a b c d e f").split(" ");
        leftShiftTwo(s1);
        System.out.println(Arrays.asList(s1));
    }
}
