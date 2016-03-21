package org.learning.algorithm.sort;

/**
 * @ClassName: SelectSort
 * @Description: 选择排序，原理：选出最小的数与第一个数交换，然后依次循环
 * @author carlos.chu
 * @date 2016年3月21日 下午1:28:13
 *
 */
public class SelectSort {

    public static void main(String[] args) {
        int a[] = { 54, 6, 3, 78, 34, 12, 45, 1 };
        int position = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i + 1;
            position = i;
            int temp = a[i];
            for (; j < a.length; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    position = j;
                }
            }
            a[position] = a[i]; // 把原数组最小数位置替换成起始比较的数
            a[i] = temp; // 把起始比较的数位置换成最小的数
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}
