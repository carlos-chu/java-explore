package org.learning.algorithm.sort;

/**
 * @ClassName: InsertSort
 * @Description: 直接插入排序，思想：在要排序的一组数中，假设前面(n-1)[n>=2]个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的
 * @author carlos.chu
 * @date 2016年3月21日 上午10:41:32
 *
 */
public class InsertSort {

    public static void main(String[] args) {
        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
                25, 53, 51 };
        int temp = 0;
        for (int i = 1; i < a.length; i++) {
            System.out.println("从第" + (i + 1) + "个数开始循环,这个数是：" + a[i]);
            int j = i - 1;
            temp = a[i];
            for (; j >= 0 && temp < a[j]; j--) {
                System.out.println("循环第" + (i + 1) + "之前的数的下标：" + (j + 1));
                a[j + 1] = a[j]; // 将大于temp的值整体后移一个单位
                System.out.println("执行完后结果是：");
                for (int k = 0; k < a.length; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println();
            }
            a[j + 1] = temp;
        }

        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
