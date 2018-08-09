package edu.hebut.wang.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble_Sort {

    public static void main(String[] args) {
        int[] A = {4,7,2,1,5,6,3};
        System.out.println(Arrays.toString(sort(A)));
    }

    public static int[] sort(int[] A) {

        int length = A.length;
        int tmp;
        int flag;

        for (int i = length - 1; i >= 0; i--) {
            flag = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j+1]) {
                    tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        return A;
    }

}
