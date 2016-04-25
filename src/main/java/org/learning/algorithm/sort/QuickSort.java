package org.learning.algorithm.sort;

/**
 * @ClassName: QuickSort
 * @Description: 快速排序,原理：选择第一个元素或者最后一个元素，通过一趟扫描，将待排序列分成两部分，一部分比基准元素小，一部分大于，然后递归排序剩下的元素
 * @author carlos.chu
 * @date 2016年3月21日 下午1:51:34
 */
public class QuickSort {

    public static void main(String[] args) {
        // int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
        // 25, 53, 51 };
        int a[] = { 49, 38, 65, 10};

        quick(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void quick(int[] a) {
        if (a.length > 0) { // 查看数组是否为空
            quickSort(a, 0, a.length - 1);
        }
    }

    private static void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);
            quickSort(list, low, middle - 1); // 对低字表进行递归排序
            quickSort(list, middle + 1, high); // 对高字表进行递归排序
        }
    }

    private static int getMiddle(int[] list, int low, int high) {
        int temp = list[low];
        while (low < high) {
            while (low < high && list[high] >= temp) {
                high--;
            }
            list[low] = list[high]; // 比中轴小的记录移到低端

            while (low < high && list[low] <= temp) {
                low++;
            }
            list[high] = list[low]; // 比中轴大的记录移到高端
        }
        list[low] = temp; // 中轴记录到尾
        for (int k = 0; k < list.length; k++) {
            System.out.print(list[k] + " ");
        }
        System.out.println();
        return low; // 返回中轴的位置
    }
}
