package edu.hebut.wang.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class Shell_Sort {

    public static void main(String[] args) {
        int[] A = {4,7,2,1,5,6,3};
        System.out.println(Arrays.toString(sort(A)));
    }

    public static int[] sort(int[] A) {

        int length = A.length;

        for (int D = length/2; D > 0; D/=2){
            for (int i = D; i < length; i++) {
                int tmp = A[i];
                int j;
                for (j = i; j >= D && A[j-D] > tmp; j-=D) {
                    A[j] = A[j-D];
                }
                A[j] = tmp;
            }
        }
        return A;

    }

}
