package org.learning.algorithm.search;

/**
 * @ClassName: TwoDimensionalArraySearch
 * @Description: 二维数组查找
 * @author carlos.chu
 * @date 2016年6月16日 上午11:21:36
 *
 */
public class TwoDimensionalArraySearch {

    public static void main(String[] args) {
        int[][] a = { { 1, 3, 5, 7 }, { 2, 4, 6, 8 }, { 3, 6, 9, 12 }, { 4, 8, 12, 16 } };

        System.out.println(contains(a, 12));
    }

    public static boolean contains(int[][] a, int key) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = a[i].length - 1; j >= 0; j--) {
                int temp = a[i][j];
                if (temp < key) {
                    for (int k = j; k < a[i].length; k++) {
                        if (a[i][k] == key) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                } else if (temp > key) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 二维数组遍历
     */
    public static void arrayItertor() {
        // 主方法
        char a[][] = new char[3][4];
        // 定义二维数组
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                // 循环遍历数组中的每个元素
                a[i][j] = '*';
                // 初始化数组内容
                System.out.print((char) a[i][j]);
                // 将数组中的元素输出
            }
            System.out.println();
            // 输出空格
        }
    }
}
