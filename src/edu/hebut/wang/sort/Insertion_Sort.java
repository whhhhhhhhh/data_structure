package edu.hebut.wang.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Insertion_Sort {

    public static void main(String[] args) {
        int[] A = {4,7,2,1,5,6,3};
        System.out.println(Arrays.toString(sort(A)));
    }

    public static int[] sort(int[] A) {

        int length = A.length;

        for (int i = 1; i < length; i++) {
            //把数组想象成只有一张牌，从第二个元素开始摸一张牌
            int tmp = A[i];
            //找到插入位置
            int j;
            for ( j = i; j > 0 && A[j-1] > tmp; j--) {
                A[j] = A[j-1];
            }
            //插入新牌
            A[j] = tmp;
        }
        return A;

    }

}
