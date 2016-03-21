package org.learning.algorithm.search;

import java.util.Arrays;

/**
 * @ClassName: BinarySearch
 * @Description: 二分法查找
 * @author carlos.chu
 * @date 2016年3月21日 下午2:27:03
 */
public class BinarySearch {

    public static void main(String[] args) {
        // java api 自带二分法查找
        binarySearchByJDK();
        // 递归二分法查找
        int[] a = { 1, 2, 3, 4, 5 };
        final int key = 3;
        int binarySearch = binarySearch(a, 0, a.length - 1, key);
        System.out.println(binarySearch);
    }

    private static int binarySearch(int list[], int lowIndex, int highIndex, int key) {
        if (lowIndex < highIndex) {
            int mid = (lowIndex + highIndex) / 2;
            if (key == list[mid]) {
                return mid;
            } else if (key < list[mid]) {
                return binarySearch(list, lowIndex, mid - 1, key);
            } else if (key > list[mid]) {
                return binarySearch(list, mid + 1, highIndex, key);
            }
        }
        return -1;
    }

    private static void binarySearchByJDK() {
        int[] a = { 1, 2, 3, 4, 5 };
        int arrayIndex = Arrays.binarySearch(a, 3);
        System.out.println("返回查找到的下标为：" + arrayIndex);
    }
}
